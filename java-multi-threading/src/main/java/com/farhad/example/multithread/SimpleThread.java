package com.farhad.example.multithread;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.work.RunableTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleThread {
    

    public void doSingleThreadedWork(RunableTask... tasks) {

        for (RunableTask task : tasks) {

            log.info("Starting Task: {}", task.name());
            task.run();
            log.info("Ending Task: {}", task.name());
        }
    }

    public void doMultiThreadedWork(RunableTask... tasks) throws InterruptedException {

        List<Thread>  taskThreads = new ArrayList<>();

        for (RunableTask task : tasks) {

            Thread taskThread = new Thread( new Runnable() {

                @Override
                public void run() {
                    log.info("Starting Task: {}", task.name());
                    task.run();
                    log.info("Ending Task: {}", task.name());
                }
                
            } , "Thread-" + task.name());

            taskThreads.add(taskThread);
        }

        // start
        for (Thread task : taskThreads) {

            task.start();
        }

        // block current thread until tasks have finished */
        for (Thread task : taskThreads) {

            task.join();        
        }

    }

}
