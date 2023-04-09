package com.farhad.example.concurrent.cyclicbarrier.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CyclicBarrierRunable implements Runnable {

    private final CyclicBarrier cyclicBarrier1 ;
    private final CyclicBarrier cyclicBarrier2 ;
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            log.info(" waiting at barrier 1");

            this.cyclicBarrier1.await();

            Thread.sleep(1000);
            log.info("waiting at barrier 2");

            this.cyclicBarrier2.await();

            log.info("done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    
}
