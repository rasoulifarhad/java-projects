package com.farhad.example.resource_acquisition_is_initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlidingDoor implements AutoCloseable {

    public SlidingDoor() {
        log.info(" Sliding door opens.");
    }

    @Override
    public void close() throws Exception {
        log.info(" Sliding door closes.");
    }
    
}
