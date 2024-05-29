package com.farhad.example.refactoring.split_phase.raw;

public class PriceOrder {

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {

        PriceData priceData = calculatePricingData(product, quantity);
        return applyShipping(priceData, shippingMethod);
    }

    private PriceData calculatePricingData(Product product, int quantity) {
        double basePrice = product.basePrice() * quantity;
        double discount = Math.max(quantity - product.discountThreshold(), 0)
            * product.basePrice() * product.discountRate();
        return new PriceData(basePrice, quantity, discount);
    }

    private double applyShipping(PriceData priceData, ShippingMethod shippingMethod) {
        double shippingPerCase = (priceData.basePrice() > shippingMethod.discountThreshold())
            ? shippingMethod.discountedFee() : shippingMethod.feePerCase();
        double shippingCost = priceData.quantity() * shippingPerCase;
        double price = priceData.basePrice() - priceData.discount() + shippingCost;
        return price;
    }
}
