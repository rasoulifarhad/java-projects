package com.farhad.example.multithread;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncCompletableFutureClass {
    
    private static final ExecutorService executorService  =  Executors.newFixedThreadPool(2);


    public void wrongServe() throws InterruptedException, ExecutionException, TimeoutException {
        
        final CompletableFuture<Response> responseFuture = asyncCode();
        final Response response = responseFuture.get(2, TimeUnit.SECONDS);

        send(response);
    }

    /**
     * Note: 
     *   this::send will be executed in the same thread that completed responseFuture.
     * 
     * We can consider separate thread pool for that:thenAcceptAsync(this::send, sendPool).
     * 
     * Good, but we lost two important properties:
     * 
     *    1. error propagation and 
     *    2. timeout. 
     */
    public void serve() throws InterruptedException, ExecutionException, TimeoutException {
        
        final CompletableFuture<Response> responseFuture = asyncCode();
        responseFuture.thenAccept(this::send);

    }

    /**
     * Note: 
     * 
     *   exceptionally() tries to recover from failure, returning alternative result. 
     *   
     *    It works here but if you chain exceptionally() with thenAccept() it will send() will 
     *    be called even in case of failure, but withnull argument (or whatever we return from 
     *    exceptionally()
     */
    public void serveExceptionally() throws InterruptedException, ExecutionException, TimeoutException {
        
        final CompletableFuture<Response> responseFuture = asyncCode();
        responseFuture.exceptionally( throwable -> {
            log.error("Unrecoverable error", throwable);
            return null ;
        });
        responseFuture.thenAccept(this::send);

    }

    /**
     * Note: 
     * 
     *   exceptionally() tries to recover from failure, returning alternative result. 
     *   
     *    It works here but if you chain exceptionally() with thenAccept() it will send() will 
     *    be called even in case of failure, but withnull argument (or whatever we return from 
     *    exceptionally()
     */
    public void serveExceptionally2() throws InterruptedException, ExecutionException, TimeoutException {
        
        final CompletableFuture<Response> responseFuture = asyncCode();
        responseFuture.exceptionally( throwable -> {
            log.error("Unrecoverable error", throwable);
            return null ;
        })
        .thenAccept(this::send); //probably not what you think

    }

    /**
     * This operator will execute block of code against first completed future, either responseFuture or oneSecondTimeout and simply ignore 
     * outcome of the slower one. 
     * 
     * If asyncCode() completes within 1 second this::send will be invoked and exception from oneSecondTimeout will 
     * get ignored. 
     * 
     * If asyncCode() is really slow, oneSecondTimeout kicks in first. But since it fails with an exception, exceptionally 
     * error handler is invoked instead of this::send. 
     * 
     * Either   send() or exceptionally will be called, not both. 
     */
    public void serveWithExceptionAndTimeout() throws InterruptedException, ExecutionException, TimeoutException {
        
        final CompletableFuture<Response> responseFuture = asyncCode();
        final CompletableFuture<Response> oneSecondTimeout = failAfter(Duration.ofSeconds(1));

        responseFuture
                    .acceptEither(oneSecondTimeout, this::send)
                    .exceptionally( throwable -> {
                        log.error("Problem", throwable);
                        return null ;
                    });

    }

    private CompletableFuture<Response> asyncCode() {

        return CompletableFuture.supplyAsync(this::doWork, executorService);
    }

    private void send(Response response)  {

        try {

            log.info("{} -- Sending response: {}",Thread.currentThread().getName(), response.id);
            Thread.sleep(200);
                
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private Response doWork()  {

        try {

            Thread.sleep(1000);
            return new Response() ;
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new Response() ;
        } 


    }

    static class Response {
        long id ;
        private static final AtomicLong _idGenerator = new AtomicLong(0);
        public Response() {
            id = _idGenerator.incrementAndGet();
        }
    }

    /**
     * A future that always fails after a given time.
     * 
     * usage: 
     *  
     *       To port timeouts without sacrificing event-driven of  CompletableFuture
     * 
     * That's simple: we create a promise (future without underlying task or thread pool) and complete it withTimeoutException 
     * after a given java.time.Duration.
     * 
     * If we call get() method of future somewhere, TimeoutException will be thrown after blocking for at least that much time. 
     * (it will be ExecutionException wrapping TimeoutException)
     * 
     * failAfter() on its own is rather useless, but combine it with responseFutureand we have a solution!
     */
    public static <T> CompletableFuture<T> failAfter(Duration duration) {

        final CompletableFuture<T> promise = new CompletableFuture<>();
        scheduler.schedule(() -> {
                final TimeoutException ex = new TimeoutException("Timeout after " + duration);
                return promise.completeExceptionally(ex);
        } , duration.toMillis(), TimeUnit.MILLISECONDS);

        return promise ;
    }

    private static final ScheduledExecutorService scheduler = 
                Executors.newScheduledThreadPool(
                        1,
                        new ThreadFactoryBuilder()
                                .setDaemon(true)
                                .setNameFormat("failAfter-%d")
                                .build());
 
    /**
     * takes one future as input and returns a future that completes when underlying one is completed. However if it 
     * takes too long to complete the underlying future, exception is thrown
     */
    public static <T> CompletableFuture<T> within(CompletableFuture<T> future, Duration duration) {
        final CompletableFuture<T> timeout = failAfter(duration);
        return future.applyToEither(timeout, Function.identity());
    }                                

    public void cleanerServe() throws InterruptedException, ExecutionException, TimeoutException {
        
        final CompletableFuture<Response> responseFuture = within( asyncCode(), Duration.ofSeconds(1));


        responseFuture
                    .thenAccept(this::send)
                    .exceptionally( throwable -> {
                        log.error("Problem", throwable);
                        return null ;
                    });

    }


}
