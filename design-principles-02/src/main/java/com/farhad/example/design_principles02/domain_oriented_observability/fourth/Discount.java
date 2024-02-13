package com.farhad.example.design_principles02.domain_oriented_observability.fourth;

public interface Discount {

	DiscountCode code();
	double applyToCart(ShoppingCart shoppingCart);

	double amount();

}
