package com.farhad.example.refactoring.split_phase.raw;

public class ShippingMethod {

    private double discountThreshold;
    private double discountedFee;
    private double feePerCase;

    public double discountThreshold() {
        return discountThreshold;
    }

    public double discountedFee() {
        return this.discountedFee;
    }

    public double feePerCase() {
        return this.feePerCase;
    }

}
