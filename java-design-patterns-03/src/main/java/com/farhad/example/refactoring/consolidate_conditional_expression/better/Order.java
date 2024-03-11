package com.farhad.example.refactoring.consolidate_conditional_expression.better;

import lombok.Data;

@Data
public class Order {

	private OrderStatus orderStatus;
	private PaymentStatus paymentStatus;
	private boolean customerSatisfied;

}
