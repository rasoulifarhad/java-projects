package com.farhad.example.codekata.beverage_prices.original;

public class TeaWithMilk extends Tea {

    @Override
    public double price() {
        return super.price() + 0.10;
    }
    
}
