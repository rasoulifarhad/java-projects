package com.farhad.example.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

import org.junit.jupiter.api.Test;

import com.farhad.example.concurrent.cyclicbarrier.cyclicbarrier.CyclicBarrierRunable;

import lombok.extern.slf4j.Slf4j;

/**
 * The java.util.concurrent.CyclicBarrier class is a synchronization mechanism that can synchronize threads progressing through some 
 * algorithm. In other words, it is a barrier that all threads must wait at, until all threads reach it, before any of the threads 
 * can continue. 
 * 
 * 
 * The threads wait for each other by calling the await() method on the CyclicBarrier. Once N threads are waiting at the CyclicBarrier, 
 * all threads are released and can continue running.
 */
@Slf4j
public class CyclicBarrierRunableTest {
    
    @Test
    public  void CyclicBarrierRunable_Test() throws InterruptedException {

        Runnable barrier1Action = new Runnable() {

            @Override
            public void run() {
                log.info("BarrierAction 1 executed");
            }
            
        };

        Runnable barrier2Action = new Runnable() {

            @Override
            public void run() {
                log.info("BarrierAction 2 executed");
            }
            
        };

        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunable barrierRunable1 = new CyclicBarrierRunable(cyclicBarrier1, cyclicBarrier2);
        CyclicBarrierRunable barrierRunable2 = new CyclicBarrierRunable(cyclicBarrier1, cyclicBarrier2);

        new Thread(barrierRunable1).start();
        new Thread(barrierRunable2).start();

        Thread.sleep(4000);

    }

}
