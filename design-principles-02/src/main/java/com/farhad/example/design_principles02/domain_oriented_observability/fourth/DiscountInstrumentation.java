package com.farhad.example.design_principles02.domain_oriented_observability.fourth;

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

	private DiscountCode discountCode;

	
	public DiscountInstrumentation(Metrics metrics, Analytics analytics, DiscountCode discountCode) {
		this.metrics = metrics;
		this.analytics = analytics;
		this.discountCode = discountCode;
	}

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


	// 

	public void discountCodeLookupSucceeded() {
		this.metrics.increment("discount-lookup-success", Collections.singletonMap("code", discountCode));
	}

	public void discountCodeLookupFailed(Exception e) {
		log.error("discount lookup failed", e);
		this.metrics.increment("discount-lookup-failure", Collections.singletonMap("code", discountCode));
	}

	public void applyingDiscountCode() {
		log.info("attempting to apply discount code: {}", discountCode);
	}	

	public void addingProductToCart(ProductId productId, ShoppingCart shoppingCart) {
		log.info("adding product {} to cart {}", productId, shoppingCart.getShoppingCartId());

	}
	public void addedProductToCart(Product product, ShoppingCart shoppingCart) {
		this.analytics.tarck("Product Added To Cart", Collections.singletonMap("sku", product.getSku()));
		this.metrics.gauge("shopping-cart-total", shoppingCart.totalPrice());
		this.metrics.gauge("shopping-cart-size", shoppingCart.size());
	}

}
