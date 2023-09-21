package com.farhad.example.codekata.beverage_prices.original;

public class CoffeeWithMilk extends Coffee {

    @Override
    public double price() {
        return super.price() + 0.10;
    }
    
    
}
