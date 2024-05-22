package com.farhad.example.refactoring.split_phase.raw;

public class Product {

    private double basePrice;
    private int  discountThreshold;
    private double discountRate;

    public double basePrice() {
        return this.basePrice;
    }

    public int discountThreshold() {
        return this.discountThreshold;
    }

    public double discountRate() {
        return discountRate;
    }

}
