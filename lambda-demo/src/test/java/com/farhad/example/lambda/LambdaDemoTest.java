package com.farhad.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaDemoTest {
    
    @Test
    public void anonymousInnerClassHelloNameRunnable() throws InterruptedException {
        final String name = "Farhad";
        Runnable greeter = new Runnable() {

            @Override
            public void run() {
                log.info("Hello {}", name);
            }
        };
        greeter.run();
    }

    @Test
    public void anonymousInnerClassHelloNameRunnableWithThread() throws InterruptedException {
        final String name = "Farhad";
        Runnable greeter = new Runnable() {

            @Override
            public void run() {
                log.info("Hello {}", name);
            }
        };
        new Thread(greeter).start();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void lambdaHelloNameRunnable() throws InterruptedException {
        String name = "Farhad";
        Runnable greeter = () -> log.info("Hello {}", name);
        new Thread(greeter).start();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void demonstrateForLoops() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        for(Integer i : ints) {
            log.info("{}", i);
        }

        ints.forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer i) {
                log.info("{}", i);
            }
        });

        ints.forEach(i -> log.info("{}", i));
    }
}
