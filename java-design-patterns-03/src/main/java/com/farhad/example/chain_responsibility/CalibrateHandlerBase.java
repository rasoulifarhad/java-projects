package com.farhad.example.chain_responsibility;

import lombok.Data;

@Data
public abstract class CalibrateHandlerBase {
    
    private CalibrateHandlerBase successor;

    public abstract double applyCorrection(Calibrate calibrate);
}
