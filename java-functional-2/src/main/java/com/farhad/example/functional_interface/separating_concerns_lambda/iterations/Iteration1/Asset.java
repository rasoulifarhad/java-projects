package com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Asset {
    
    public enum AssetType {
        BOND, STOCK
    }

    private final AssetType type;
    private final int value;
}
