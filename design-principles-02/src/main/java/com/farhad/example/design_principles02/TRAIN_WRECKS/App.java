package com.farhad.example.design_principles02.TRAIN_WRECKS;

public class App {
	
	// This chunk of code is traversing five levels of abstraction, from customer to total amounts. Ultimately our top-level code has to
	// know that a customer object exposes orders, that the orders have a find method that takes an order id and returns an order, and that the order object has a totals object which has getters and setters for grand totals and discounts. That’s a lot of implicit knowledge.
	public void applyDiscount(Customer customer, long order_id, double discount) {
		Totals totals = customer	
							.orders
							.find(order_id)
							.getTotals();
		totals.grandTotal = totals.grandTotal - discount;
		totals.discount = discount;
	}

	// Tell, Don’t Ask
	public void applyDiscount2(Customer customer, long order_id, double discount) {
		Totals totals = customer	
							.orders
							.find(order_id)
							.getTotals()
							.applyDiscount(discount);
	}

	// Tell, Don’t Ask
	public void applyDiscount3(Customer customer, long order_id, double discount) {
		Totals totals = customer	
							.findOrder(order_id)
							.getTotals()
							.applyDiscount(discount);
	}

	// Tell, Don’t Ask
	public void applyDiscount4(Customer customer, long order_id, double discount) {
		Totals totals = customer	
							.findOrder(order_id)
							.applyDiscount(discount);
	}

}
