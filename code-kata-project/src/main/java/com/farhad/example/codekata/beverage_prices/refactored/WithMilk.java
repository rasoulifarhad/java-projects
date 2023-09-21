package com.farhad.example.codekata.beverage_prices.refactored;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WithMilk implements Beverage {

    private final Beverage beverage;

    @Override
    public double price() {
        return beverage.price() + 0.10;
    }
    
}
