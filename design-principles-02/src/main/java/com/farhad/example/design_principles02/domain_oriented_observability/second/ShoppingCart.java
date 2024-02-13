package com.farhad.example.design_principles02.domain_oriented_observability.second;

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

		instrumentApplyingDiscountCode(discountCode);
		Discount discount;
		try {
			discount = discountService.lookupDiscount(discountCode);
		} catch (Exception e) {
			instrumentDiscountCodeLookupFailed(discountCode, e);
			return 0;
		}

		instrumentDiscountCodeLookupSucceeded(discountCode);

		double amountDiscounted = discount.applyToCart(this);

		instrumentDiscountApplied(discount, amountDiscounted);

		return amountDiscounted;
	}
	
	public void addToCard(ProductId productId) {

		instrumentAddingProductToCart(productId, this);

		Product product = productService.lookupProduct(productId);

		products.add(product);
		recalculateTotal();

		instrumentAddedProductToCart(product, this);

	}
	

	public void instrumentAddingProductToCart(ProductId productId, ShoppingCart shoppingCart) {
		log.info("adding product {} to cart {}", productId, shoppingCart.getShoppingCartId());

	}

	public void instrumentAddedProductToCart(Product product, ShoppingCart shoppingCart) {
		this.analytics.tarck("Product Added To Cart", Collections.singletonMap("sku", product.getSku()));
		this.metrics.gauge("shopping-cart-total", shoppingCart.totalPrice());
		this.metrics.gauge("shopping-cart-size", shoppingCart.size());
	}

	private double totalPrice() {
		return 0;
	}

	private void recalculateTotal() {
	}

	public int size() {
		return products.size();
	}

	private void instrumentDiscountApplied(Discount discount, double amountDiscounted) {
		log.info("Discount applied, of amount: {}", amountDiscounted);
		Map<String, Object> map = new HashMap<>();
		map.put("code", discount.code());
		map.put("discount", discount.amount()) ;
		map.put("amountDiscounted", amountDiscounted) ;
		this.analytics.tarck("Discount code applied", map);
	}
	private void instrumentDiscountCodeLookupSucceeded(DiscountCode discountCode) {
		this.metrics.increment("discount-lookup-success", Collections.singletonMap("code", discountCode));
	}
	private void instrumentDiscountCodeLookupFailed(DiscountCode discountCode, Exception e) {
		log.error("discount lookup failed", e);
		this.metrics.increment("discount-lookup-failure", Collections.singletonMap("code", discountCode));
	}
	private void instrumentApplyingDiscountCode(DiscountCode discountCode) {
		log.info("attempting to apply discount code: {}", discountCode);
	}
}
