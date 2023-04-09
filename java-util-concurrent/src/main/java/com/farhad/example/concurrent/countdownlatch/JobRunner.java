package com.farhad.example.concurrent.countdownlatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobRunner {

    private List<Job> jobs = null;
    CountDownLatch latch ;

    public JobRunner(Job... jobs) {
        this( new CountDownLatch(jobs.length), jobs);
    }

    public JobRunner(CountDownLatch latch, Job... jobs) {
        this.jobs = Arrays.asList(jobs);
        this.latch = latch;
    }

    public void run() {

        for (Job job : jobs) {
            new Thread( new Runnable() {

                @Override
                public void run() {
                    Job wrappedJob = new CountdownlatchBasedJobWrapper(job, latch);
                    wrappedJob.doJob();
                }
                
            } ).start();  ;  
        }

        try {
            log.info("Waiting jobs finish......");
            latch.await();
            log.info("All jobs done.");
            // latch.await(jobs.length * 1 , TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.info("InterruptedException ......"  );
            e.printStackTrace();
        }
        
    }
}
