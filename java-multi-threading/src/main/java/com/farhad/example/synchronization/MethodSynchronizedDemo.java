package com.farhad.example.synchronization;

import java.util.concurrent.ThreadLocalRandom;

import lombok.extern.slf4j.Slf4j;

/**
 * ycrash --> yc-data-script
 * 
 * ./yc -j {JAVA_HOME} -onlyCapture -p {PID} -hd
 */
@Slf4j
public class MethodSynchronizedDemo {
    
    private static final int BOY_COUNT = 10 ;
    private static GirlFriend  girlFriend = new GirlFriend();

    public static class GirlFriend {

        public synchronized void meet() {
            log.info("{} meeting started!", Thread.currentThread().getName());
            int sleepTime = ThreadLocalRandom.current().nextInt(1000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                log.error("Thread interupted", e);
            }
            log.info("{} meeting ended!", Thread.currentThread().getName());
        }
    }

    public static class BoyFriendThread extends Thread {

        @Override
        public void run() {
            girlFriend.meet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        for (int i = 0; i < BOY_COUNT ; i++) {
            BoyFriendThread boyFriendThread = new BoyFriendThread();
            boyFriendThread.setName("BoyFriend-" + i);
            boyFriendThread.start();
        }
    }
}
