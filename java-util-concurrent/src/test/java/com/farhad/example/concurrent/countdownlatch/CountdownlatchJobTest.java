package com.farhad.example.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountdownlatchJobTest {
    
    @Test
    public void CountdownlatchJobTest() throws InterruptedException {

        Job job1 = new DefaultJobImpl("job-1");
        Job job2 = new DefaultJobImpl("job-2");
        Job job3 = new DefaultJobImpl("job-3");

        JobRunner runner = new JobRunner(job1, job2, job3);

        runner.run();

        Thread.sleep(4000);

    }

    @Test
    public void CountdownlatchJobTest2() throws InterruptedException {

        Job job1 = new DefaultJobImpl("job-1");
        Job job2 = new DefaultJobImpl("job-2");
        Job job3 = new DefaultJobImpl("job-3");

        CountDownLatch latch =  new CountDownLatch(3) ;
        JobRunner runner = new JobRunner(latch, job1, job2, job3);

        runner.run();

        latch.await();

    }

}
