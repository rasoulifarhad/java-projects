package com.farhad.example.ddd_tips.aggregate_root.orders;

import java.util.Objects;

import com.farhad.example.ddd_tips.aggregate_root.orders.Product.ProductId;

import lombok.Getter;
import lombok.Setter;

@Getter
public class OrderItem  extends LocalEntity<Long>{

    private Order order;
	@Setter
    private ProductId product;
	@Setter
    private String description;
    private int quantity;
    private Money price;
    private Money subTotal;	

	public OrderItem(Long nextFreeItemId, Order order) {
		super(nextFreeItemId);
		this.order = Objects.requireNonNull(order);
		this.quantity = 0;
		this.price = Money.ZERO;
		recalculateSubTotal();
	}

	private void recalculateSubTotal() {
		Money oldSubTotal = this.subTotal;
		this.subTotal = price.multiply(quantity);
		if (oldSubTotal != null && !oldSubTotal.equals(this.subTotal)) {
			this.order.recalculateTotals();
		}
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}
		this.quantity = quantity;
		recalculateSubTotal();
	}

	public void setPrice(Money price) {
		this.price = Objects.requireNonNull(price);
		recalculateSubTotal();
	}

}
