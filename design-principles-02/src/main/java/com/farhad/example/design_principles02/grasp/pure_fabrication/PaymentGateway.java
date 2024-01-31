package com.farhad.example.design_principles02.grasp.pure_fabrication;

// In a payment processing system, the PaymentGateway interface protects the system from changes in the implementations 
// of different payment methods, like CreditCardPayment or PayPalPayment.
public interface PaymentGateway {

	void processPayment(double amount);
}
