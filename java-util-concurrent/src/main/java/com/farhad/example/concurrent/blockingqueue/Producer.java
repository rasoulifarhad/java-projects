package com.farhad.example.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Producer implements Runnable {

    final BlockingQueue<String> queue ;

    @Override
    public void run() {
        
        try {
            queue.put("One");
            Thread.sleep(1000);

            queue.put("Two");
            Thread.sleep(1000);

            queue.put("Three");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
}
