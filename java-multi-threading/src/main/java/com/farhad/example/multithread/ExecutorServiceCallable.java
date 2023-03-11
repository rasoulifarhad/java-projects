package com.farhad.example.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.farhad.example.work.CalcResult;
import com.farhad.example.work.CallableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceCallable {
    
    public void submitCallableTasks( ExecutorService executorService, CallableTask...tasks ) throws InterruptedException, ExecutionException {

        try {
            
            List<Future<CalcResult>> taskFutureList = new ArrayList<>();

            for (CallableTask callableTask : tasks) {
                
                taskFutureList.add( executorService.submit(() -> {
                                        log.info("Starting Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());
                                        CalcResult res =  callableTask.call();
                                        log.info("Ending Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());

                                        return res ;
                                    }) );
            }

            for (Future<CalcResult> future : taskFutureList) {
                
                // get Double result from Future when it becomes available

                CalcResult taskResult = future.get();

                log.info("Task {} returned value {}", taskResult);
            }

        } finally {
        }
    }


    public void submitCallableTasksWithExecutor( CallableTask...tasks ) throws InterruptedException, ExecutionException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(tasks.length);
            List<Future<CalcResult>> taskFutureList = new ArrayList<>();

            for (CallableTask callableTask : tasks) {
                
                taskFutureList.add( executorService.submit(() -> {
                                        log.info("Starting Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());
                                        CalcResult res =  callableTask.call();
                                        log.info("Ending Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());

                                        return res ;
                                    }) );
            }

            for (Future<CalcResult> future : taskFutureList) {
                
                // get Double result from Future when it becomes available

                CalcResult taskResult = future.get();

                log.info("Task {} returned value {}", taskResult);
            }

        } finally {
            executorService.shutdown();
        }
    }

    public void submitCallableTasksWithExecutorChangeThreadName( CallableTask...tasks ) throws InterruptedException, ExecutionException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(tasks.length);
            List<Future<CalcResult>> taskFutureList = new ArrayList<>();

            for (CallableTask callableTask : tasks) {
                
                taskFutureList.add( executorService.submit(() -> {
                                        log.info("Starting Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());

                                        final Thread currentThread = Thread.currentThread() ;
                                        final String oldName = currentThread.getName();
                                        currentThread.setName("Processing-" + callableTask.name());

                                        CalcResult res ;

                                        try {

                                            log.info("Starting Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());
                                            res =  callableTask.call();
                                            
                                            log.info("Ending Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());
                                        } finally {
                                            currentThread.setName(oldName);
                                        }

                                        log.info("Ending Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());

                                        return res ;
                                    }) );
            }

            for (Future<CalcResult> future : taskFutureList) {
                
                // get Double result from Future when it becomes available

                CalcResult taskResult = future.get();

                log.info("Task {} returned value {}", taskResult);
            }

        } finally {
            executorService.shutdown();
        }
    }

    public void submitCallableTasksWithCompletionService(CallableTask... tasks) {

        ExecutorService executorService = null;
        CompletionService<CalcResult> taskCompletionService = null;

        try {

            executorService = Executors.newFixedThreadPool(tasks.length);
            taskCompletionService = new  ExecutorCompletionService<>(executorService);

            for (CallableTask callableTask : tasks) {

                taskCompletionService.submit(callableTask);
                
            }
            int tasksSubmited = tasks.length;
            for (int tasksHandled = 0; tasksHandled < tasksSubmited; tasksHandled++) {
                
                log.info("Try to take from Completion Service");

                // blocks till atleast one task is completed and results availble
                Future<CalcResult> calcResultFuture = taskCompletionService.take();

                log.info("result for a task available. trying  to get it");

                CalcResult calcResult = calcResultFuture.get();
                log.info("Task {} Complated. Result: {}", tasksHandled, calcResult);


            }
        } catch (InterruptedException e) {
            log.error("Interrupted Exception ");
            e.printStackTrace();
        } catch (ExecutionException e) {
            log.error("get() threw Exception ");
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public void submitCallableTasksWithExecutorInvokeAll( CallableTask...tasks ) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(tasks.length);
            List<Callable<CalcResult>> callableTaskList = new ArrayList<>();

            for (CallableTask callableTask : tasks) {
                callableTaskList.add( () ->  {
                    log.info("Starting Task: {} in thread: {}", callableTask.name(), Thread.currentThread().getName());
                    CalcResult res =  callableTask.call();
                    log.info("Ending Task: {} in thread: {}", callableTask.name(), Thread.currentThread().getName());

                    return res ;

                });
            }

            List<Future<CalcResult>> callableTaskFutureList =  executorService.invokeAll(callableTaskList);

            for (Future<CalcResult> future : callableTaskFutureList) {
                
                // get Double result from Future when it becomes available

                CalcResult taskResult = future.get(4, TimeUnit.SECONDS);

                log.info("Task returned value {}", taskResult);
            }

        } finally {
            executorService.shutdown();
        }
    }

    public void submitDivideByZeroWithExecutorWhithoutGet() throws InterruptedException, ExecutionException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(1);
            Future<Integer> future = executorService.submit(() -> {

                                        log.info("Starting divide by zero in thread: {}", 
                                                                    Thread.currentThread().getName());
                                        int res = 1/0 ;
                                        log.info("Ending divide by zero in thread: {}", 
                                                                    Thread.currentThread().getName());
                                        return res ;
                                    }) ;
            // int taskResult = future.get();
            // log.info("Task divide by zero returned value {}", taskResult);
            

        } finally {
            executorService.shutdown();
        }

    }

    public void submitDivideByZeroWithExecutorWhitGet() throws InterruptedException, ExecutionException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(1);
            Future<Integer> future = executorService.submit(() -> {

                                        log.info("Starting divide by zero in thread: {}", 
                                                                    Thread.currentThread().getName());
                                        int res = 1/0 ;
                                        log.info("Ending divide by zero in thread: {}", 
                                                                    Thread.currentThread().getName());
                                        return res ;
                                    }) ;
            int taskResult = future.get();
            log.info("Task divide by zero returned value {}", taskResult);
            

        } finally {
            executorService.shutdown();
        }

    }

    /**
     * 
     * Instead of: 
     * 
     *    final Future<BigDecimal> future = executorService.submit(this::calculate);
     * 
     * we do :
     * 
     *   final CompletableFuture<BigDecimal> future = CompletableFuture.supplyAsync(this::calculate, executorService);
     * 
     * @param tasks
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public void submitCallableTasksWithCompletableFuture( CallableTask...tasks ) throws InterruptedException, ExecutionException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(tasks.length);
            List<Future<CalcResult>> taskFutureList = new ArrayList<>();

            for (CallableTask callableTask : tasks) {
                
                taskFutureList.add( executorService.submit(() -> {
                                        log.info("Starting Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());
                                        CalcResult res =  callableTask.call();
                                        log.info("Ending Task: {} in thread: {}", 
                                                                    callableTask.name(), 
                                                                    Thread.currentThread().getName());

                                        return res ;
                                    }) );
            }

            for (Future<CalcResult> future : taskFutureList) {
                
                // get Double result from Future when it becomes available

                CalcResult taskResult = future.get();

                log.info("Task {} returned value {}", taskResult);
            }

        } finally {
            executorService.shutdown();
        }
    }

}
