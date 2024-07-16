package com.farhad.example.codekata.tire_pressure_kata;

import java.util.Random;

public class Sensor {

    private static  double OFFSET = 16;


    public double popNextPressurePsiValue() {

        double pressureTelemetryValue = samplePressure();
        return OFFSET + pressureTelemetryValue;
    }


    private double samplePressure() {
        // placeholder implementation that simulates a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        return 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();        
    }


    
}
