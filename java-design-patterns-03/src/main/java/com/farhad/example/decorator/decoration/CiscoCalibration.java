package com.farhad.example.decorator.decoration;

public class CiscoCalibration extends VendorCalibration{

    @Override
    public double calibrate(double rawData) {
        return rawData *0.8567;
    }
}
