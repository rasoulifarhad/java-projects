package com.farhad.example.refactoring.split_phase.raw;

public class PriceData {

    private double basePrice;
    private int quantity;
    private double discount;

    public PriceData(double basePrice, int quantity, double discount) {
        this.basePrice = basePrice;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double basePrice() {
        return this.basePrice;
    }

    public int quantity() {
        return quantity;
    }

    public double discount() {
        return discount;
    }
}
