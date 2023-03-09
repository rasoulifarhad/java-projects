package com.farhad.example.multithread;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.farhad.example.work.ExpensiveRunableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleThreadTest {
    

    @Test
    public void doSingleThreadedWorkTest() {

        ExpensiveRunableTask task1 = new ExpensiveRunableTask();
        ExpensiveRunableTask task2 = new ExpensiveRunableTask();

        LocalDateTime start = LocalDateTime.now() ;

        SimpleThread simpleThread = new SimpleThread() ;
        simpleThread.doSingleThreadedWork(task1, task2);

        log.info("doSingleThreadedWork tooks {} ms", ChronoUnit.MILLIS.between(start, LocalDateTime.now()) );
    }

    @Test
    public void doMultiThreadedWorkTest() throws InterruptedException {

        ExpensiveRunableTask task1 = new ExpensiveRunableTask();
        ExpensiveRunableTask task2 = new ExpensiveRunableTask();

        LocalDateTime start = LocalDateTime.now() ;

        SimpleThread simpleThread = new SimpleThread() ;
        simpleThread.doMultiThreadedWork(task1, task2);

        log.info("doMultiThreadedWork tooks {} ms", ChronoUnit.MILLIS.between(start, LocalDateTime.now()) );

    }
}
