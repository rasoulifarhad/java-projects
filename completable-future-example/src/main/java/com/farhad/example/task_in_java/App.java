package com.farhad.example.task_in_java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<String> task = () -> "select user from users";
        ExecutorService executorService =  Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(task);

        System.out.println("result: " + future.get());
        executorService.shutdown();
    }

}
