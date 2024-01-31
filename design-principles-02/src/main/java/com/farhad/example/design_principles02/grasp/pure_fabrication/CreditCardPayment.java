package com.farhad.example.design_principles02.grasp.pure_fabrication;

public class CreditCardPayment implements PaymentGateway {

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing credit card payment: " + amount);		
	}

}
