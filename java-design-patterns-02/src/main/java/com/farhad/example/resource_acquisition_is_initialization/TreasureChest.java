package com.farhad.example.resource_acquisition_is_initialization;

import java.io.Closeable;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TreasureChest implements Closeable{

    public TreasureChest() {
        log.info("Treasure chest opens.");
    }

    @Override
    public void close() throws IOException {
        log.info("Treasure chest closes.");
    }
    
}
