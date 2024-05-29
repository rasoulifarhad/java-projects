package com.farhad.example.refactoring.split_phase.raw;

public class PriceOrder {

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {

        double basePrice = product.basePrice() * quantity;
        double discount = Math.max(quantity - product.discountThreshold(), 0)
            * product.basePrice() * product.discountRate();
        PriceData priceData = new PriceData(basePrice, quantity);
        double price = applyShipping(priceData, shippingMethod, discount);
        return price;
    }

    private double applyShipping(PriceData priceData, ShippingMethod shippingMethod, double discount) {
        double shippingPerCase = (priceData.basePrice() > shippingMethod.discountThreshold())
            ? shippingMethod.discountedFee() : shippingMethod.feePerCase();
        double shippingCost = priceData.quantity() * shippingPerCase;
        double price = priceData.basePrice() - discount + shippingCost;
        return price;
    }
}
