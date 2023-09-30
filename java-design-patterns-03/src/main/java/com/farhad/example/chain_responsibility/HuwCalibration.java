package com.farhad.example.chain_responsibility;

public class HuwCalibration extends CalibrateHandlerBase {

    @Override
    public double applyCorrection(Calibrate calibrate) {
        System.out.println("Huw calibration called");
        if(calibrate.getVendor().equals("HUW")) {
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
