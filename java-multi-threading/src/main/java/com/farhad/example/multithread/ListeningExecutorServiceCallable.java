package com.farhad.example.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.farhad.example.work.CalcResult;
import com.farhad.example.work.CallableTask;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListeningExecutorServiceCallable {
    
    public void submitCallableTasksWithListeningExecutorService( CallableTask...tasks ) throws InterruptedException {

        ExecutorService executorService = null;
        ListeningExecutorService listeningExecutorService = null;
        try {
            executorService = Executors.newFixedThreadPool(tasks.length);
            listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

            for (CallableTask callableTask : tasks) {
                ListenableFuture<CalcResult> listenableFuture = 
                        listeningExecutorService.submit( () -> {
                                log.info("Starting Task: {} in thread: {}", 
                                                        callableTask.name(), 
                                                        Thread.currentThread().getName());
                                CalcResult res =  callableTask.call();
                                log.info("Ending Task: {} in thread: {}", 
                                                        callableTask.name(), 
                                                        Thread.currentThread().getName());
                                return res ;
                            } ) ;
                Futures.addCallback(listenableFuture, new FutureCallback<CalcResult>() {

                    @Override
                    public void onFailure(Throwable t) {
                        log.error("Exception in Task {}",callableTask.name(), t);
                    }

                    @Override
                    public void onSuccess(CalcResult result) {
                        log.info("OnSuccess for Task {}",callableTask.name());
                       
                    }
                    
                }, 
                listeningExecutorService);

            }


        } finally {
            
            listeningExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        }

    }
}
