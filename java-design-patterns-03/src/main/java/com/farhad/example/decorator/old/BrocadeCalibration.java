package com.farhad.example.decorator.old;

public class BrocadeCalibration extends VendorCalibration{

    @Override
    public double calibrate(double rawData) {
        return rawData * .967;
    }
    
}
