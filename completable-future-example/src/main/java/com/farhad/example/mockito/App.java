package com.farhad.example.mockito;

import static org.mockito.Mockito.mock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.mockito.Mockito;

import com.farhad.example.mockito.AsyncResponse.StringResult;

public class App {

    private AsyncResource resource;
    private ExecutorService executor;
    private StringResult result;
    private AsyncResponse response;


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        App app = new App();
        app.setup();
        app.test();
        app.teardown();
    }

    private void test() throws InterruptedException, ExecutionException, TimeoutException {
        Runnable train = () -> Mockito.doReturn(result).when(response).longOperation();        
        Runnable verify = () -> Mockito.verify(response).resume(result);
        final Runnable callAndVerify = () -> resource.executeAsync(response).thenRun(verify);

       CompletableFuture
            .runAsync(train, executor)
            .thenRun(callAndVerify)
            .get(10, TimeUnit.SECONDS );    
        }

    private void teardown() {
        resource = null;
        result = null;
        response = null;
        executor.shutdown();
    }

    private void setup(){
        executor = Executors.newSingleThreadExecutor();
        resource = new AsyncResource(executor);
        result = mock(StringResult.class);
        response = mock(AsyncResponse.class);        
    }

}
