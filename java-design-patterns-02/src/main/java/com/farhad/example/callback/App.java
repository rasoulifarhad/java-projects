package com.farhad.example.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    
    public static void main(String[] args) {
        
        SimpleTask task = new SimpleTask();
        Callback callback = new Callback() {

            @Override
            public void call() {
                log.info("callback called.");
            }
            
        };
        task.executeWith(callback);

        SimpleTask anotherTask = new SimpleTask();
        Callback lambdaCallback = () -> log.info("lambda callback called.");
        anotherTask.executeWith(lambdaCallback);
    }
}
