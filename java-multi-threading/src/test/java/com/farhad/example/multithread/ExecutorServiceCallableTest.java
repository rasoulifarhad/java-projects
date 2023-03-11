package com.farhad.example.multithread;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.farhad.example.work.ExpensiveCallableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceCallableTest {
    
    @Test
    public void submitCallableTasksWithExecutorTest() throws InterruptedException, ExecutionException {

        ExpensiveCallableTask task1 = new ExpensiveCallableTask();
        ExpensiveCallableTask task2 = new ExpensiveCallableTask();

        Instant start = Instant.now() ;

        new ExecutorServiceCallable().submitCallableTasksWithExecutor(task1, task2);

        log.info("submitCallableTaskWithExecutorTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));

    }

    @Test
    public void submitCallableTasksWithCompletionServiceTest() {

        ExpensiveCallableTask task1 = new ExpensiveCallableTask();
        ExpensiveCallableTask task2 = new ExpensiveCallableTask();

        Instant start = Instant.now() ;

        new ExecutorServiceCallable().submitCallableTasksWithCompletionService(task1, task2);

        log.info("submitCallableTasksWithCompletionServiceTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));

    }

    @Test
    public void submitCallableTasksWithExecutorChangeThreadNameTest() throws InterruptedException, ExecutionException {

        ExpensiveCallableTask task1 = new ExpensiveCallableTask();
        ExpensiveCallableTask task2 = new ExpensiveCallableTask();

        Instant start = Instant.now() ;

        new ExecutorServiceCallable().submitCallableTasksWithExecutorChangeThreadName(task1, task2);

        log.info("submitCallableTasksWithExecutorChangeThreadNameTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
    }

    @Test
    public void submitDivideByZeroWithExecutorWhithoutGet() throws InterruptedException, ExecutionException {

        new ExecutorServiceCallable().submitDivideByZeroWithExecutorWhithoutGet();
    }

    @Test
    public void submitDivideByZeroWithExecutorWhitGet() throws InterruptedException, ExecutionException {

        Exception  exception =   
        assertThrows(ExecutionException.class, () -> {
            new ExecutorServiceCallable().submitDivideByZeroWithExecutorWhitGet();
        });
        log.info("Exception thrown: {}", exception.getMessage());

        assertInstanceOf(ArithmeticException.class, exception.getCause());
       
    }

    /**
     * 
     * We created a thread pool with two threads and a SynchronousQueue in front of it.
     * 
     * Because SynchronousQueue is essentially a queue with 0 capacity, such ExecutorService
     * will only accept new tasks if there is an idle thread available. 
     * 
     * If all threads are busy, new task will be rejected immediately and will never wait. 
     * 
     * This behaviour might be desirable when processing in background must start immediately or 
     * be discarded.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void executorServiceWithSynchronousQueueTestThrowRejectedExecutionException() throws InterruptedException, ExecutionException {
        
        ExpensiveCallableTask task1 = new ExpensiveCallableTask();
        ExpensiveCallableTask task2 = new ExpensiveCallableTask();
        ExpensiveCallableTask task3 = new ExpensiveCallableTask();
        ExpensiveCallableTask task4 = new ExpensiveCallableTask();
        
        BlockingQueue<Runnable> queue = new SynchronousQueue<>();

        final ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, queue);
        try {

            Instant start = Instant.now() ;
            Exception  exception =   
                            assertThrows(RejectedExecutionException.class, () -> {
                                new ExecutorServiceCallable().submitCallableTasks(executorService, task1, task2, task3, task4);
                            });
            log.info("Exception thrown: {}", exception.getMessage());
            log.info("executorServiceWithSynchronousQueueTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
                
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            
        }


    }

        /**
     * 
     * We created a thread pool with two threads and a SynchronousQueue in front of it.
     * 
     * Because SynchronousQueue is essentially a queue with 0 capacity, such ExecutorService
     * will only accept new tasks if there is an idle thread available. 
     * 
     * If all threads are busy, new task will be rejected immediately and will never wait. 
     * 
     * This behaviour might be desirable when processing in background must start immediately or 
     * be discarded.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void executorServiceWithSynchronousQueueTestOk() throws InterruptedException, ExecutionException {
        
        ExpensiveCallableTask task1 = new ExpensiveCallableTask();
        ExpensiveCallableTask task2 = new ExpensiveCallableTask();

        
        BlockingQueue<Runnable> queue = new SynchronousQueue<>();
        ExecutorService executorService = null;

        try {
            executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, queue);

            Instant start = Instant.now() ;
    
            new ExecutorServiceCallable().submitCallableTasks(executorService, task1, task2);
    
            log.info("executorServiceWithSynchronousQueueTest tooks {} ms", ChronoUnit.MILLIS.between(start, Instant.now()));
                
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            
        }
    }

}
