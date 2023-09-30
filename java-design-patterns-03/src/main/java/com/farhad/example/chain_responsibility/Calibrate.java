package com.farhad.example.chain_responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Calibrate {
    
    private String vendor;
    private String deviceType;
    private String techType;
    private double rawData;
}
