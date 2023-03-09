package com.farhad.example.multithread;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.farhad.example.work.ExpensiveCallableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceCallableTest {
    
    @Test
    public void submitCallableTaskWithExecutorTest() throws InterruptedException, ExecutionException {

        ExpensiveCallableTask task1 = new ExpensiveCallableTask();
        ExpensiveCallableTask task2 = new ExpensiveCallableTask();

        Instant start = Instant.now() ;

        new ExecutorServiceCallable().submitCallableWithExecutor(task1, task2);

        log.info("submitCallableTaskWithExecutorTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));

    }

}
