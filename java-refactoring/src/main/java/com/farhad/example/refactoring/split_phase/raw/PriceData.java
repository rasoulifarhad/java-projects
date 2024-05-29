package com.farhad.example.refactoring.split_phase.raw;

public class PriceData {

    private double basePrice;

    public PriceData(double basePrice) {
        this.basePrice = basePrice;
    }

    public double basePrice() {
        return this.basePrice;
    }
}
