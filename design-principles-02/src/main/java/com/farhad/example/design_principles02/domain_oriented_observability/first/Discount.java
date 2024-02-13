package com.farhad.example.design_principles02.domain_oriented_observability.first;

public interface Discount {

	double applyToCart(ShoppingCart shoppingCart);

	double amount();

}
