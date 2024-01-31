package com.farhad.example.design_principles02.grasp.pure_fabrication;

import lombok.Data;

@Data
public class ShoppingCart {

	private PaymentGateway paymentGateway;

	public void checkout(double amount) {
		paymentGateway.processPayment(amount);
	}

}
