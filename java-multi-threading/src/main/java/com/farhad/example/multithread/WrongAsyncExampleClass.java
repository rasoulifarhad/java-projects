package com.farhad.example.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Prefer CompletableFuture
 * 
 * Instead of:
 * 
 *   final Future<V> future = executorService.submit(this::doWork);
 * 
 * do: 
 * 
 *   final CompletableFuture<V> future =  CompletableFuture.supplyAsync(this::doWork, executorService);
 */
@Slf4j
public class WrongAsyncExampleClass {

    private static final ExecutorService executorService  =  Executors.newFixedThreadPool(2);


    public void serve() throws InterruptedException, ExecutionException, TimeoutException {
        
        final Future<Response> responseFuture = asyncCode();
        final Response response = responseFuture.get(2, TimeUnit.SECONDS);

        send(response);
    }

    private Future<Response> asyncCode() {

        return executorService.submit(this::doWork);
    }

    private void send(Response response) throws InterruptedException {
        log.info("Sending response: {}",response.id);
        Thread.sleep(200);
    }
    
    private Response doWork() throws InterruptedException {
        Thread.sleep(1000);
        return new Response() ;


    }

    static class Response {
        long id ;
        private static final AtomicLong _idGenerator = new AtomicLong(0);
        public Response() {
            id = _idGenerator.incrementAndGet();
        }
    }
}
