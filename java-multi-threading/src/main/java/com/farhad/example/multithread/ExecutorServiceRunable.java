package com.farhad.example.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.farhad.example.work.RunableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceRunable {
    

    /**
     * Use an ExecutorService to execute 2 Runnables that call expensive task
     * @throws InterruptedException
     */
    public void doExecuteTasksWithExecutor(RunableTask... tasks) throws InterruptedException {

        ExecutorService executorService = null; 

        try {
            executorService =  Executors.newFixedThreadPool(tasks.length);
            for (RunableTask task : tasks) {
                
                executorService.execute( () -> {
                    log.info("Starting Task: {} in thread: {}", task.name(), Thread.currentThread().getName());
                    task.run();
                    log.info("Ending Task: {} in thread: {}", task.name(), Thread.currentThread().getName());
    
                } );
            }
                
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }

    }

    /**
     * Use an ExecutorService to execute 2 Runnables that call expensive
     */
    public void doSubmitTasksWithExecutor(RunableTask... tasks) {

        ExecutorService executorService = null; 
        List<Future<?>> futures = new ArrayList<>();
        executorService =  Executors.newFixedThreadPool(tasks.length);
        for (RunableTask task : tasks) {
            
            Future<?> future =  executorService.submit( () -> {
                                        log.info("Starting Task: {} in thread: {}", task.name(), Thread.currentThread().getName());
                                        task.run();
                                        log.info("Ending Task: {} in thread: {}", task.name(), Thread.currentThread().getName());

            } );

            futures.add(future);
        }

        // check if tasks have completed - if not  sleep and after 1 second check again
            
        shutdownAndAwaitTermination(executorService);
                

    }

        /**
     * Use an ExecutorService to execute 2 Runnables that call expensive
         * @throws ExecutionException
         * @throws InterruptedException
     */
    public void doSubmitTasksWithExecutor1(RunableTask... tasks) throws InterruptedException, ExecutionException {

        ExecutorService executorService = null; 
        List<Future<?>> futures = new ArrayList<>();
        try {
            
            executorService =  Executors.newFixedThreadPool(tasks.length);
            for (RunableTask task : tasks) {
                
                Future<?> future =  executorService.submit( () -> {
                                            log.info("Starting Task: {} in thread: {}", task.name(), Thread.currentThread().getName());
                                            task.run();
                                            log.info("Ending Task: {} in thread: {}", task.name(), Thread.currentThread().getName());
    
                } );
    
                futures.add(future);
            }
    
            // check if tasks have completed - if not  sleep and after 1 second check again
            for (Future<?> future : futures) {
                future.get();
            }    
        } finally {
            executorService.shutdown();
        }
    }

    public void doSubmitTasksWithExecutor2(RunableTask... tasks) throws InterruptedException {

        CountDownLatch _latch = new CountDownLatch(tasks.length);
        ExecutorService executorService = null; 
        try {
            executorService =  Executors.newFixedThreadPool(tasks.length);
            for (RunableTask task : tasks) {
                
                executorService.submit( () -> {
                        try {
                            log.info("Starting Task: {} in thread: {}", task.name(), Thread.currentThread().getName());
                            task.run();
                            log.info("Ending Task: {} in thread: {}", task.name(), Thread.currentThread().getName());
                        } finally {
                            _latch.countDown();
                        }
    
                } );

            }

            // check if tasks have completed - if not  sleep and after 1 second check again
            _latch.await();     
            
                
        } finally {
            executorService.shutdown();
        }

    }

    void shutdownAndAwaitTermination( ExecutorService executorService ) {

        executorService.shutdown();

        try {
            
            if ( executorService.awaitTermination(60, TimeUnit.SECONDS) ) {
                executorService.shutdownNow();
            } 
        } catch (InterruptedException e) {
            
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }

    public void doExecuteDivideByZeroWithExecutor() throws InterruptedException {

        ExecutorService executorService = null; 

        try {
            executorService =  Executors.newFixedThreadPool(1);
            executorService.execute( () -> {
                log.info("Starting divide by zero in thread: {}", Thread.currentThread().getName()); 
                log.info("1 / 0 : {}", 1 / 0);
                log.info("Ending divide by zero in thread: {}", Thread.currentThread().getName());

            } );
                
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }

    }

    public void doSubmitDivideByZeroWithExecutor() throws InterruptedException {

        ExecutorService executorService = null; 

        try {
            executorService =  Executors.newFixedThreadPool(1);
            executorService.submit( () -> {
                log.info("Starting divide by zero in thread: {}", Thread.currentThread().getName()); 
                log.info("1 / 0 : {}", 1 / 0);
                log.info("Ending divide by zero in thread: {}", Thread.currentThread().getName());

            } );
                
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }

    }


}
