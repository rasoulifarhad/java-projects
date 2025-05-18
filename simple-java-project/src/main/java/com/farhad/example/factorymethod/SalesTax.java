package com.farhad.example.factorymethod;

public abstract class SalesTax {

    protected double rate;

    abstract double getRate();

    public void calculateTax(double amount) {
        System.out.printf("$%6.2f\n", (amount * (1.0 + rate)));
    }

}


