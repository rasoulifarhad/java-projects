package com.farhad.example.multithread;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.farhad.example.work.ExpensiveRunableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceRunableTest {
    

    @Test
    public void doExxecuteRunableTaskWithExecutorTest() throws InterruptedException {

        ExpensiveRunableTask task1 = new ExpensiveRunableTask();
        ExpensiveRunableTask task2 = new ExpensiveRunableTask();

        Instant start = Instant.now() ;

        new ExecutorServiceRunable().doExecuteTasksWithExecutor(task1, task2);

        log.info("doExxecuteRunableTaskWithExecutorTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));

    }

    @Test
    public void doSubmitRunableTaskWithExecutorTest() {
        
        ExpensiveRunableTask task1 = new ExpensiveRunableTask();
        ExpensiveRunableTask task2 = new ExpensiveRunableTask();

        Instant start = Instant.now() ;

        new ExecutorServiceRunable().doSubmitTasksWithExecutor(task1, task2);

        log.info("doExxecuteRunableTaskWithExecutorTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
    }

    @Test
    public void doExecuteDivideByZeroWithExecutorTest() throws InterruptedException {


        Instant start = Instant.now() ;

        new ExecutorServiceRunable().doExecuteDivideByZeroWithExecutor();

        log.info("doExecuteDivideByZeroWithExecutorTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));

    }

    @Test
    public void doSubmitDivideByZeroWithExecutorTest() throws InterruptedException {


        Instant start = Instant.now() ;

        new ExecutorServiceRunable().doSubmitDivideByZeroWithExecutor();

        log.info("doSubmitDivideByZeroWithExecutorTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));

    }

}
