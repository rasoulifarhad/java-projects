package com.farhad.example.decorator.decoration;

public class App {
    public static void main(String[] args) {
        double rawData = 2.345;
        double calibratedData = 
                    new DeviceTypeCalibration(
                        new TechTypeCalibration(
                            new HuwCalibration())).calibrate(rawData);
        System.out.println(calibratedData);
    }
}
