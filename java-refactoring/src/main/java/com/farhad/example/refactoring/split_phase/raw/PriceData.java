package com.farhad.example.refactoring.split_phase.raw;

public class PriceData {

    private double basePrice;
    private int quantity;

    public PriceData(double basePrice, int quantity) {
        this.basePrice = basePrice;
        this.quantity = quantity;
    }

    public double basePrice() {
        return this.basePrice;
    }

    public int quantity() {
        return quantity;
    }
}
