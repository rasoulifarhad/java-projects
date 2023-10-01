package com.farhad.example.decorator.old;

public class CiscoCalibration extends VendorCalibration{

    @Override
    public double calibrate(double rawData) {
        return rawData *0.8567;
    }
}
