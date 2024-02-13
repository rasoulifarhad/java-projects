package com.farhad.example.design_principles02.domain_oriented_observability.first;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ShoppingCart {


	private final DiscountService discountService;

	private Metrics metrics;
	private Analytics analytics;
	public double applyDiscountCode(DiscountCode discountCode) {
		
		log.info("attempting to apply discount code: {}", discountCode);
		Discount discount;
		try {
			discount = discountService.lookupDiscount(discountCode);
		} catch (Exception e) {
			log.error("discount lookup failed", e);
			this.metrics.increment("discount-lookup-failure", Collections.singletonMap("code", discountCode));
			return 0;
		}

		this.metrics.increment("discount-lookup-success", Collections.singletonMap("code", discountCode));
		
		double amountDiscounted = discount.applyToCart(this);
		
		log.info("Discount applied, of amount: {}", amountDiscounted);
		Map<String, Object> map = new HashMap<>();
		map.put("code", discountCode);
		map.put("discount", discount.amount()) ;
		map.put("amountDiscounted", amountDiscounted) ;
		this.analytics.tarck("Discount code applied", map);

		return amountDiscounted;
	}
}
