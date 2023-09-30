package com.farhad.example.chain_responsibility;

public class PortCalibration extends CalibrateHandlerBase {

    @Override
    public double applyCorrection(Calibrate calibrate) {
        System.out.println("Port calibration called");
        if(calibrate.getDeviceType().equals("PORT")) {
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
