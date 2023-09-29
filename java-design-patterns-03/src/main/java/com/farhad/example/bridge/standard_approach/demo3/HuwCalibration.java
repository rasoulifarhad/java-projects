package com.farhad.example.bridge.standard_approach.demo3;

public class HuwCalibration extends VendorCalibration {

    @Override
    public double calibrate(Double rawData) {
        return rawData * 0.945;
    }

    
}
