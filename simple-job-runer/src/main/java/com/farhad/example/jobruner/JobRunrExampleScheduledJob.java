package com.farhad.example.jobruner;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;

@Slf4j
public class JobRunrExampleScheduledJob {
    
    public static class HelloJob {
        public HelloJob() {

        }
        
        public void sayHello(String framework, Instant createdAt) {
            log.info("{} say Hello at {}", framework, createdAt);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        JobScheduler jobScheduler = JobRunrFactory.initializeJobRuner();
        jobScheduler.<HelloJob>schedule(ZonedDateTime.now().plus(1, ChronoUnit.MINUTES), x -> x.sayHello("JobRuner", Instant.now()));

        Thread.currentThread().join();
    }
}
