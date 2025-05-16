package com.farhad.example.birdfeeder;

public class Sensor {
    private Integer lightLevel;
   
    public Sensor() {
        lightLevel = 0;
    }

    public Integer getLevel() {
        lightLevel = (int)(Math.random() * 100);
        return lightLevel;
    }
}
