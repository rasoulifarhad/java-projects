package com.farhad.example.multithread;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncCompletableFutureClassTest {
    

    @Test
    public void wrongServeTest() throws InterruptedException, ExecutionException, TimeoutException {

        Instant start = Instant.now() ;

        new AsyncCompletableFutureClass().wrongServe();

        log.info("wrongServeTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));


    }

    @Test
    public void serveTest() throws InterruptedException, ExecutionException, TimeoutException {

        Instant start = Instant.now() ;

        new AsyncCompletableFutureClass().serve();

        log.info("serveTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
        TimeUnit.SECONDS.sleep(2);

    }

    @Test
    public void serveExceptionallyTest() throws InterruptedException, ExecutionException, TimeoutException {

        Instant start = Instant.now() ;

        new AsyncCompletableFutureClass().serveExceptionally();
        log.info("serveExceptionally tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
        TimeUnit.SECONDS.sleep(2);

    }

    @Test
    public void serveExceptionally2Test() throws InterruptedException, ExecutionException, TimeoutException {

        Instant start = Instant.now() ;

        new AsyncCompletableFutureClass().serveExceptionally2();

        log.info("serveExceptionally2Test tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
        TimeUnit.SECONDS.sleep(2);

    }

    @Test
    public void serveWithExceptionAndTimeoutTest() throws InterruptedException, ExecutionException, TimeoutException {

        Instant start = Instant.now() ;

        new AsyncCompletableFutureClass().serveWithExceptionAndTimeout();

        log.info("serveWithExceptionAndTimeoutTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
        TimeUnit.SECONDS.sleep(2);

    }

    @Test
    public void cleanerServeTest() throws InterruptedException, ExecutionException, TimeoutException {

        Instant start = Instant.now() ;

        new AsyncCompletableFutureClass().cleanerServe();

        log.info("cleanerServeTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
        TimeUnit.SECONDS.sleep(2);

    }

    @Test
    public void usingAsyncVersionOfApplyRunTransformationsTest() throws InterruptedException, ExecutionException {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = 
                                CompletableFuture.supplyAsync(() -> {
                                    log.info("Sleeping.");
                                    try {
                                        Thread.sleep(2000);
                                    } catch(Exception e ) {
                                        e.printStackTrace();
                                    }
                                    return "ABCDEF";
                                }, pool);
        future.thenApplyAsync( s ->  {
            log.info("First Transformation.");
            return s.length();
        }) ;    
        
        future.thenApplyAsync( s -> {
            log.info("Second Transformation.");
            return s.length();
        }, pool);

        future.get();
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    public void whatThreadRunTransformationsTest() throws InterruptedException, ExecutionException {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = 
                                CompletableFuture.supplyAsync(() -> {
                                    log.info("Sleeping.");
                                    try {
                                        Thread.sleep(2000);
                                    } catch(Exception e ) {
                                        e.printStackTrace();
                                    }
                                    return "ABCDEF";
                                }, pool);
        future.thenApply( s ->  {
            log.info("First Transformation.");
            return s.length();
        }) ;    
        
        future.get();
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        future.thenApply( s -> {
            log.info("Second Transformation.");
            return s.length();
        });
    }

    ExecutorService pool2;

    @Test
    public void usingThenComposeTransformationsTest() throws InterruptedException, ExecutionException {

        pool2 = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = 
                                CompletableFuture.supplyAsync(() -> {
                                    log.info("Sleeping.");
                                    try {
                                        Thread.sleep(2000);
                                    } catch(Exception e ) {
                                        e.printStackTrace();
                                    }
                                    return "ABCDEF";
                                }, pool2);
        CompletableFuture<Void> voidFuture = 
                            future
                                .thenCompose(s -> strLen(s))
                                .thenApply(i -> {
                                    log.info("first Transformation."); 
                                    return i;})
                                .thenAccept(i -> {
                                    log.info("Consume: {}", i); });
        voidFuture.get();
        pool2.shutdown();
        pool2.awaitTermination(1, TimeUnit.MINUTES);
    }

    private CompletableFuture<Integer> strLen(String s) {
        return CompletableFuture.supplyAsync(() -> s.length(),pool2);
    }

}
