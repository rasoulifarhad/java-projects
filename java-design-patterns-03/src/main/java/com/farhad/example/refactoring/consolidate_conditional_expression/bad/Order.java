package com.farhad.example.refactoring.consolidate_conditional_expression.bad;

import lombok.Data;

@Data
public class Order {

	private OrderStatus orderStatus;
	private PaymentStatus paymentStatus;
	private boolean customerSatisfied;

}
