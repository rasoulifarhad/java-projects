package com.farhad.example.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Consumer implements Runnable {

    final BlockingQueue<String> queue ;

    @Override
    public void run() {
    
        try {
            log.info("taked: {}", queue.take()); 
            log.info("taked: {}", queue.take()); 
            log.info("taked: {}", queue.take()); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
