package com.farhad.example.multithread;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.farhad.example.work.ExpensiveCallableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListeningExecutorServiceCallableTest {
    
    @Test
    public void submitCallableTasksWithListeningExecutorServiceTest() throws InterruptedException {

        ExpensiveCallableTask task1 = new ExpensiveCallableTask();
        ExpensiveCallableTask task2 = new ExpensiveCallableTask();

        Instant start = Instant.now() ;

        new ListeningExecutorServiceCallable().submitCallableTasksWithListeningExecutorService(task1, task2);

        log.info("submitCallableTasksWithListeningExecutorServiceTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));


        // TimeUnit.SECONDS.sleep(5);
    }
}
