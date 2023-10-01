package com.farhad.example.decorator.old;

public class HuwCalibration extends VendorCalibration{

    @Override
    public double calibrate(double rawData) {
        return rawData * 0.945;
    }
}
