package com.farhad.example.bridge.standard_approach.demo3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Group3 extends GroupCalibration {

    private VendorCalibration vendorCalibration;

    @Override
    public double applyCorrection(Double rawData) {
        Double groupCalibrated = rawData * 0.8889 + 0.0645;
        return vendorCalibration.calibrate(groupCalibrated);
    }
    
}
