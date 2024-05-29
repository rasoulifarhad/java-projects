package com.farhad.example.refactoring.split_phase.raw;

public class PriceOrder {

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {

        double basePrice = product.basePrice() * quantity;
        double discount = Math.max(quantity - product.discountThreshold(), 0)
            * product.basePrice() * product.discountRate();
        double price = applyShipping(basePrice, shippingMethod, quantity, discount);
        return price;
    }

    private double applyShipping(double basePrice, ShippingMethod shippingMethod,  int quantity, double discount) {
        double shippingPerCase = (basePrice > shippingMethod.discountThreshold())
            ? shippingMethod.discountedFee() : shippingMethod.feePerCase();
        double shippingCost = quantity * shippingPerCase;
        double price = basePrice - discount + shippingCost;
        return price;
    }
}
