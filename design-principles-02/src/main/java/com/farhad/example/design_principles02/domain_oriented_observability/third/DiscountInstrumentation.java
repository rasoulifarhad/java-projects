package com.farhad.example.design_principles02.domain_oriented_observability.third;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DiscountInstrumentation {

	private final Metrics metrics;
	private final Analytics analytics;

	public void discountApplied(Discount discount, double amountDiscounted) {
		log.info("Discount applied, of amount: {}", amountDiscounted);
		Map<String, Object> map = new HashMap<>();
		map.put("code", discount.code());
		map.put("discount", discount.amount()) ;
		map.put("amountDiscounted", amountDiscounted) ;
		this.analytics.tarck("Discount code applied", map);
	}
	
	public void discountCodeLookupSucceeded(DiscountCode discountCode) {
		this.metrics.increment("discount-lookup-success", Collections.singletonMap("code", discountCode));
	}
	
	public void discountCodeLookupFailed(DiscountCode discountCode, Exception e) {
		log.error("discount lookup failed", e);
		this.metrics.increment("discount-lookup-failure", Collections.singletonMap("code", discountCode));
	}
	
	public void applyingDiscountCode(DiscountCode discountCode) {
		log.info("attempting to apply discount code: {}", discountCode);
	}

}
