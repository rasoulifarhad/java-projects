package com.farhad.example.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CountdownlatchBasedJobWrapper implements Job {
    
    private final Job job;
    final CountDownLatch countDownLatch;
    
    @Override
    public String name() {
        return job.name();
    }

    @Override
    public void doJob() {
        job.doJob();
        done();
    }

     private void done() {
        countDownLatch.countDown(); 
    }


}
