package com.farhad.example.design_principles02.another_grasp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Customer {

	private UUID id;
	private String email;
	private String name;

	private List<Order> orders;
	
	private Customer() {
		orders = new ArrayList<>();
	}

	public Customer(String email, String name, CustomerUniquenessChecker customerUniquenessChecker) {
		this.email = email;
		this.name = name;

		boolean isUnique = customerUniquenessChecker.isUnique(this);
		if (!isUnique) {
			throw new BusinessRuleValidationException("Customer with this email already exists.");
		}
		
		this.addDomainEvent(new CustomerRegisteredEvent(this));
	}

	public void addOrder(Order order) {
		int todaysOrders = (int) orders.stream()
			.filter(o -> o.isOrderedToday() )
				.count();
		if (todaysOrders >= 2) {
			throw new BusinessRuleValidationException("You cannot order more than 2 orders on the same day");
		}
		this.orders.add(order);
		this.addDomainEvent(new OrderAddedEvent(order));
	}
	private void addDomainEvent(OrderAddedEvent orderAddedEvent) {
	}

	private void addDomainEvent(CustomerRegisteredEvent customerRegisteredEvent) {
	}

	public void removeOrder(UUID orderId) {
		Order order = orders.stream()
			.filter(o -> o.getId().equals(orderId))
				.findFirst().orElse(null);
		if (order != null) {
			order.remove();
		}
		this.addDomainEvent(new OrderRemovedEvent(order));
	}

	private void addDomainEvent(OrderRemovedEvent orderRemovedEvent) {
	}

	public void changeOrder(UUID orderId, List<OrderProduct> products, List<ConversionRate> conversionRates) {

		Order order = orders.stream()
				.filter(o -> o.getId().equals(orderId))
				.findFirst().orElse(null);
		if (order != null) {
			order.change(products, conversionRates);
		}
		this.addDomainEvent(new OrderChangedEvent(order));
	}
	
	private void addDomainEvent(OrderChangedEvent orderChangedEvent) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addDomainEvent'");
	}

	public double getOrdersTotal(UUID orderId) {
		return 0;
	}
}
