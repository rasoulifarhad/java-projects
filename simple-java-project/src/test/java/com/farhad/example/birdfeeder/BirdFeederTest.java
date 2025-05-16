package com.farhad.example.birdfeeder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BirdFeederTest {

    private BirdFeeder birdFeeder;

    @BeforeEach
    public void setup() {
        birdFeeder = new BirdFeeder();
    }

    @SuppressWarnings("static-access")
    @Test
    public void birdFeederTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Testing  the bird feeder.");
            birdFeeder.operate();
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted" + e.getMessage());
                System.exit(1);
            }
        }
    }
}
