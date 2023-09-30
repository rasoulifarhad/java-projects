package com.farhad.example.chain_responsibility;

public class App {
    
    public static void main(String[] args) {
        
        CalibrateHandlerBase huwCalibration = new HuwCalibration();
        CalibrateHandlerBase ciscoCalibration = new CiscoCalibration();
        CalibrateHandlerBase portCalibration = new PortCalibration();
        CalibrateHandlerBase vdslCalibration = new VdslCalibration();

        huwCalibration.setSuccessor(ciscoCalibration);
        ciscoCalibration.setSuccessor(portCalibration);
        portCalibration.setSuccessor(vdslCalibration);
        
        double calibratedData = huwCalibration.applyCorrection(
            new Calibrate("HUW", "PORT", "VDSL", 2));        
        System.out.println(calibratedData);

        calibratedData = huwCalibration.applyCorrection(
            new Calibrate("HUW", "PORT", "ADSL", 2));
        System.out.println(calibratedData);
        
    }

}

