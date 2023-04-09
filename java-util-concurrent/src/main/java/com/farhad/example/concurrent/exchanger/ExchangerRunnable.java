package com.farhad.example.concurrent.exchanger;

import java.util.concurrent.Exchanger;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
public class ExchangerRunnable implements Runnable {
    
    private final Exchanger<String> exchanger ;
    private String exchangee;

    @Override
    public void run() {
        try {
            String  previous = this.exchangee ;
            this.exchangee = this.exchanger.exchange(this.exchangee);
            log.info("exchanged {} for {}", previous, this.exchangee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
}
