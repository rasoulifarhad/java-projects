package com.farhad.example.design_principles02.domain_oriented_observability.sixth;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ShoppingCart {


	@Getter
	private ShoppingCartId shoppingCartId;
	
	private final DiscountService discountService;
	private final ProductService productService;

	private final ObservationAnnouncer announcer;

	private List<Product> products = new ArrayList<>();

	public double applyDiscountCode(DiscountCode discountCode) {

		applyingDiscountCode(discountCode);
		Discount discount;
		try {
			discount = discountService.lookupDiscount(discountCode);
		} catch (Exception e) {
			discountCodeLookupFailed(discountCode, e);
			return 0;
		}

		discountCodeLookupSucceeded(discountCode);

		double amountDiscounted = discount.applyToCart(this);

		discountApplied(discount, amountDiscounted);

		return amountDiscounted;
	}
	
	private void applyingDiscountCode(DiscountCode discountCode) {
		announcer.announce(new ApplyingDiscountCode(discountCode));
	}

	private void discountCodeLookupFailed(DiscountCode discountCode, Exception ex) {
		announcer.announce(new DiscountCodeLookupFailed(discountCode, ex));
	}

	private void discountCodeLookupSucceeded(DiscountCode discountCode) {
		announcer.announce(new DiscountCodeLookupSucceeded(discountCode));
	}

	private void discountApplied(Discount discount, double amountDiscounted) {
		announcer.announce(new DiscountApplied(discount.code()));
	}



	public double totalPrice() {
		return 0;
	}

	public int size() {
		return products.size();
	}

}
