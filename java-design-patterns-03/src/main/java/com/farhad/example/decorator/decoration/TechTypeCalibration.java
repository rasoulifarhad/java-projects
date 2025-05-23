package com.farhad.example.decorator.decoration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechTypeCalibration extends CalibrationDecorator {

    private VendorCalibration vendorCalibration;

    @Override
    double calibrate(double rawData) {
        return vendorCalibration.calibrate(rawData) * 0.978;
    }
    
}
