package com.farhad.example.codekata.beverage_prices.original;

public class HotChocolateWithCream extends HotChocolate {

    @Override
    public double price() {
        return super.price() + 0.15;
    }
    
}
