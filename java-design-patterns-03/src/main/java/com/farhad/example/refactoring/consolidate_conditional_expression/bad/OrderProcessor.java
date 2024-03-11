package com.farhad.example.refactoring.consolidate_conditional_expression.bad;

public class OrderProcessor {


	public void processOrder(Order order) {

		if(order.getOrderStatus() == OrderStatus.PENDING) {
			if(order.getPaymentStatus() == PaymentStatus.PAID) {
				// Process order logic...
			} else if(order.getPaymentStatus() == PaymentStatus.PENDDING) {
				// Handle pending payment logic...
			}
		} else if (order.getOrderStatus() == OrderStatus.SHIPPED) {
			// Handle shipped order logic...
		} else if (order.getOrderStatus() == OrderStatus.DELIVERED) {
			if (order.isCustomerSatisfied()) {
				// Handle satisfied customer logic...
			} else {
				// Handle unsatisfied customer logic...
			}
		}
	}
}
