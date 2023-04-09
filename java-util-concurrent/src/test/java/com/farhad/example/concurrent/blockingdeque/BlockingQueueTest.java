package com.farhad.example.concurrent.blockingdeque;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.jupiter.api.Test;

import com.farhad.example.concurrent.blockingqueue.Consumer;
import com.farhad.example.concurrent.blockingqueue.Producer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockingQueueTest {
    
    @Test
    public void blockingQueueTest() throws InterruptedException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(5000);
    }
}
