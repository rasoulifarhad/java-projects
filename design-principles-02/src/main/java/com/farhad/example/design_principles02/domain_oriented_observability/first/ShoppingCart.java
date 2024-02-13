package com.farhad.example.design_principles02.domain_oriented_observability.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private Metrics metrics;
	private Analytics analytics;
	private List<Product> products = new ArrayList<>();

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
		map.put("discount", discount.amount());
		map.put("amountDiscounted", amountDiscounted);
		this.analytics.tarck("Discount code applied", map);

		return amountDiscounted;
	}
	
	public void addToCard(ProductId productId) {

		log.info("adding product {} to cart {}", productId, shoppingCartId);
		Product product = productService.lookupProduct(productId);

		products.add(product);
		recalculateTotal();

		this.analytics.tarck("Product Added To Cart", Collections.singletonMap("sku", product.getSku()));
		this.metrics.gauge("shopping-cart-total", this.totalPrice());
		this.metrics.gauge("shopping-cart-size", this.products.size());

	}

	private double totalPrice() {
		return 0;
	}

	private void recalculateTotal() {
	}

	public int size() {
		return products.size();
	}

}
