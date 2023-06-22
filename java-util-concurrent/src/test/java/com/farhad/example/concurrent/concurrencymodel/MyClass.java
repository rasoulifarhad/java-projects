package com.farhad.example.concurrent.concurrencymodel;

import java.util.concurrent.ThreadLocalRandom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RequiredArgsConstructor
public class MyClass {
    
    private final MyAppState appState;

    synchronized public void blockedUpdateState() {
        log.info("Starting update......");
        //  
        updateState();
        //
        log.info("Ending update......");
    }

    private void updateState() {
        // expensive operation
        try {
            appState.updateState();
            Thread.sleep( ThreadLocalRandom.current().nextInt(500, 2000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    static class MyAppState {
        private int state = 0;
        
        public void updateState() {
            if ( state % 2 != 0) {
                state++;
            } 
        }
    }
}
