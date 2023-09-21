package com.farhad.example.codekata.beverage_prices.original;

public class CoffeeWithMilkAndCream extends Coffee {

    @Override
    public double price() {
        return super.price() + 0.25;
    }
    
}
