package com.farhad.example.chain_responsibility;

public class VdslCalibration extends CalibrateHandlerBase  {

    @Override
    public double applyCorrection(Calibrate calibrate) {
        System.out.println("Vdsl calibration called");
        if(calibrate.getTechType().equals("VDSL")) {
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
