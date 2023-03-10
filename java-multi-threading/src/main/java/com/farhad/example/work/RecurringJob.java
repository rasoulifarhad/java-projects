package com.farhad.example.work;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * This code is wrong on so many layers! 
 * 
 *   1. Starting Thread in a constructor might not be a good idea in some environments, e.g. some frameworks like Spring will 
 *      create dynamic subclass to support method interception. We will end-up with two threads running from two instances.
 * 
 *   2. InterruptedException is swallowed, and the exception itself is not logged properly
 * 
 *   3. This class starts a new thread for every instance, it should use ScheduledThreadPoolExecutor instead, shared among many 
 *      instances (more robust and memory-effective)
 * 
 *   4. Also with ScheduledThreadPoolExecutor we could avoid coding sleeping/working loop by ourselves, and also switch to fixed-rate 
 *     as opposed to fixed-delay behaviour presented here.
 * 
 *   5. Last but not least there is no way to get rid of this thread, even when Cleaner instance is no longer referenced by anything 
 *      else
 */
@Slf4j
public class RecurringJob implements Runnable {

    public RecurringJob() {

        final Thread jobThread = new Thread(this, "RecurringJob");
        jobThread.start();
    }

    @Override
    public void run() {
        
        while (true) {
            
            job();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void job() {
        log.info("Start doing job");
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
