package com.farhad.example.bridge.standard_approach.demo3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Group2 extends GroupCalibration {

    private VendorCalibration vendorCalibration;

    @Override
    public double applyCorrection(Double rawData) {
        Double groupCalibrated = rawData * 0.9289 + 0.0445;
        return vendorCalibration.calibrate(groupCalibrated);
    }
    
}
