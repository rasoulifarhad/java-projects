package com.farhad.example.concurrent.countdownlatch;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DefaultJobImpl implements Job {

    final String name ;
    
    @Override
    public String name() {
        return name;
    }

    @Override
    public void doJob() {
        try {
            log.info("Job {} started");
            Thread.sleep(1000);
            log.info("Job {} finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
