package com.farhad.example.design_principles02.domain_oriented_observability.third;


import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ShoppingCart {


	private ShoppingCartId shoppingCartId;
	
	private final DiscountService discountService;
	private final ProductService productService;

	private final DiscountInstrumentation instrumentation;

	private List<Product> products = new ArrayList<>();

	public double applyDiscountCode(DiscountCode discountCode) {

		instrumentation.applyingDiscountCode(discountCode);
		Discount discount;
		try {
			discount = discountService.lookupDiscount(discountCode);
		} catch (Exception e) {
			instrumentation.discountCodeLookupFailed(discountCode, e);
			return 0;
		}

		instrumentation.discountCodeLookupSucceeded(discountCode);

		double amountDiscounted = discount.applyToCart(this);

		instrumentation.discountApplied(discount, amountDiscounted);

		return amountDiscounted;
	}
	
	public void addToCard(ProductId productId) {

		instrumentation.addingItemToCart(productId, shoppingCartId);
		Product product = productService.lookupProduct(productId);

		products.add(product);
		recalculateTotal();

		instrumentation.itemAddedToCart(product, totalPrice(), products.size());

	}

	private double totalPrice() {
		return 0;
	}

	private void recalculateTotal() {
	}
}
