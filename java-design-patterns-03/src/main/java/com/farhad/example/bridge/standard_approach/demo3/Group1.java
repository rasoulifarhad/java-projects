package com.farhad.example.bridge.standard_approach.demo3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Group1 extends GroupCalibration {

    private VendorCalibration vendorCalibration;

    @Override
    public double applyCorrection(Double rawData) {
        Double groupCalibrated = rawData *  0.9889 + 0.0345;
        return vendorCalibration.calibrate(groupCalibrated);
    }
    
}
