package com.farhad.example.resource_acquisition_is_initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    
    public static void main(String[] args) throws Exception {
        
        try (SlidingDoor slidingDoor = new SlidingDoor()) {
            log.info("Walking in.");
        } 

        try (TreasureChest treasureChest = new TreasureChest()) {
            log.info("Looting contents.");
        } 
    }
}
