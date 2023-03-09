package com.farhad.example.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.farhad.example.work.CallableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceCallable {
    

    public void submitCallableWithExecutor( CallableTask...tasks ) throws InterruptedException, ExecutionException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(tasks.length);
            List<Future<Double>> taskFutureList = new ArrayList<>();

            for (CallableTask callableTask : tasks) {
                
                Future<Double> taskFuture = executorService.submit(() -> {
                    log.info("Starting Task: {} in thread: {}", callableTask.name(), Thread.currentThread().getName());
                    Double res =  callableTask.call();
                    log.info("Ending Task: {} in thread: {}", callableTask.name(), Thread.currentThread().getName());

                    return res ;
                });
                taskFutureList.add(taskFuture);
            }

            for (Future<Double> future : taskFutureList) {
                
                // get Double result from Future when it becomes available

                Double taskResult = future.get();

                log.info("Task {} returned value {}", taskResult);
            }

        } finally {
            executorService.shutdown();
        }
    }

    public void submitCallableWithExecutor2( CallableTask...tasks ) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = null;

        try {
            
            executorService = Executors.newFixedThreadPool(tasks.length);
            List<Callable<Double>> callableTaskList = new ArrayList<>();

            for (CallableTask callableTask : tasks) {
                callableTaskList.add( () ->  {
                    log.info("Starting Task: {} in thread: {}", callableTask.name(), Thread.currentThread().getName());
                    Double res =  callableTask.call();
                    log.info("Ending Task: {} in thread: {}", callableTask.name(), Thread.currentThread().getName());

                    return res ;

                });
            }

            List<Future<Double>> callableTaskFutureList =  executorService.invokeAll(callableTaskList);

            for (Future<Double> future : callableTaskFutureList) {
                
                // get Double result from Future when it becomes available

                Double taskResult = future.get(4, TimeUnit.SECONDS);

                log.info("Task returned value {}", taskResult);
            }

        } finally {
            executorService.shutdown();
        }
    }

}
