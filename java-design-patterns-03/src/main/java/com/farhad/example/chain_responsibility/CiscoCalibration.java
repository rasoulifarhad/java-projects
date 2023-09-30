package com.farhad.example.chain_responsibility;

public class CiscoCalibration extends CalibrateHandlerBase {

    @Override
    public double applyCorrection(Calibrate calibrate) {
        System.out.println("Cisco calibration called");
        if(calibrate.getVendor().equals("CISCO")) {
            calibrate.setRawData(calibrate.getRawData() * 2);
            if(getSuccessor() != null){
                return getSuccessor().applyCorrection(calibrate);
            } else {
                return calibrate.getRawData();
            }
        } else {
            if (getSuccessor() != null) {
                return getSuccessor().applyCorrection(calibrate);
            } else {
                return calibrate.getRawData();
            }
        }
    }
    
}
