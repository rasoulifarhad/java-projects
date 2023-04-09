package com.farhad.example.concurrent.exchanger;

import java.util.concurrent.Exchanger;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExchangerTest {
    
    @Test
    public void exchangerTest() throws InterruptedException{
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "One");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "Two");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();

        Thread.sleep(2000);
    }
}
