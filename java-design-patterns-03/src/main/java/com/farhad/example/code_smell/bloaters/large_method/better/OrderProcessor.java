package com.farhad.example.code_smell.bloaters.large_method.better;

public class OrderProcessor {

	public void processOrder(Order order) {

		if (!isValidOrder(order)) {
			handleInvalidOrder(order);
			return;
		}
		double totalPrice = calculateTotalPrice(order);
		applyDiscounts(order, totalPrice);
		updateInventory(order);
		sendOrderConfirmation(order);
		logOrderDetails(order, totalPrice);
	}

	private void handleInvalidOrder(Order order) {
		logError("Invalid order");
	}

	private void logOrderDetails(Order order, double totalPrice) {
	}

	private void sendOrderConfirmation(Order order) {
	}

	private void updateInventory(Order order) {
	}

	private void applyDiscounts(Order order, double totalPrice) {
	}

	private double calculateTotalPrice(Order order) {
		return 0.0;
	}

	private void logError(String message) {
		System.out.println(message);
	}


	private boolean isValidOrder(Order order) {
		return true;
	}
}
