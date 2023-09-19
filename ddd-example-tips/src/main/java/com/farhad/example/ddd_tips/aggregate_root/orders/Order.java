package com.farhad.example.ddd_tips.aggregate_root.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.farhad.example.ddd_tips.aggregate_root.orders.Customer.CustomerId;
import com.farhad.example.ddd_tips.aggregate_root.orders.Order.OrderId;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;


@Setter(value = AccessLevel.PRIVATE)
@Getter
public class Order extends AggregateRoot<OrderId> {
	 
 	private CustomerId customer;
    private String shippingName;
    private PostalAddress shippingAddress;
    private String billingName;
    private PostalAddress billingAddress;
    private Money total;
    private Long nextFreeItemId;
    private List<OrderItem> items = new ArrayList<>();

	public Order(Customer customer) {
		super(OrderId.createRandomUnique());
		Objects.requireNonNull(customer);
		setCustomer(customer.getId());
		setShippingName(customer.getName());
        setShippingAddress(customer.getAddress());
        setBillingName(customer.getName());
        setBillingAddress(customer.getAddress());
		nextFreeItemId = 1L;
        recalculateTotals();
	}

	@RequiredArgsConstructor
	@Value
	static class OrderId {
		public static OrderId createRandomUnique() {
			return new OrderId(UUID.randomUUID().toString());
		}

		private final String id;
	}

	public void changeShippingAddress(String name, PostalAddress address) {
		setShippingName(name);
		setShippingAddress(address);
	}

	public void changeBillingAddress(String name, PostalAddress address) {
		setBillingName(name);
		setBillingAddress(address);
	}

	private Long getNextFreeItemId() {
		return nextFreeItemId++;
	}

	void recalculateTotals() {
		this.total = items.stream().map(OrderItem::getSubTotal).reduce(Money.ZERO, Money::add);
	}

	public OrderItem addItem(Product product) {
		OrderItem item = new OrderItem(getNextFreeItemId(), this);
		item.setProduct(product.getId());
		item.setDescription(product.getName());
		this.items.add(item);
		return item;
	}

}
