package com.farhad.example.refactoring.consolidate_conditional_expression.better;

public class OrderProcessor {


	public void processOrder(Order order) {

		if (order.getOrderStatus() == OrderStatus.PENDING && order.getPaymentStatus() == PaymentStatus.PAID) {
			// Process order logic...
		} else if (order.getOrderStatus() == OrderStatus.PENDING
				&& order.getPaymentStatus() == PaymentStatus.PENDDING) {
			// Handle pending payment logic...
		} else if (order.getOrderStatus() == OrderStatus.SHIPPED) {
			// Handle shipped order logic...
		} else if (order.getOrderStatus() == OrderStatus.DELIVERED && order.isCustomerSatisfied()) {
			// Handle satisfied customer logic...
		} else if (order.getOrderStatus() == OrderStatus.DELIVERED) {
			// Handle unsatisfied customer logic...
		}
	}
	
	public void processOrder2(Order order) {
		switch (order.getOrderStatus()) {
			case PENDING:
				handlePendingOrderLogic(order);
				break;
			case SHIPPED:
				handleShippedOrderLogic(order);
				break;
			case DELIVERED:
				handleDeliveredOrderLogic(order);
				break; 
		}
	}

	private void handleDeliveredOrderLogic(Order order) {
		if (order.isCustomerSatisfied()) {
			handlesatisfiedCustomerLogic(order);
		} else {
			handleUnsatisfiedCustomerLogic(order);
		}

	}

	private void handleUnsatisfiedCustomerLogic(Order order) {
	}

	private void handlesatisfiedCustomerLogic(Order order) {
	}

	private void handleShippedOrderLogic(Order order) {
	}

	private void handlePendingOrderLogic(Order order) {
		switch (order.getPaymentStatus()) {
			case PAID:
				processOrderLogic(order);				
				break;
			case PENDDING:
				handlePendingPaymentLogic(order);
				break;
		}
	}

	private void handlePendingPaymentLogic(Order order) {
	}

	private void processOrderLogic(Order order) {
	}

}
