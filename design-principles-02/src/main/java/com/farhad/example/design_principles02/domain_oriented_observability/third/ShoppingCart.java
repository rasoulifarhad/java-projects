package com.farhad.example.design_principles02.domain_oriented_observability.third;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ShoppingCart {


	private final DiscountService discountService;


	private final DiscountInstrumentation instrumentation;

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
}
