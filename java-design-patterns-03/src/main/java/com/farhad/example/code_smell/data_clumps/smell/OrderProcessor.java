package com.farhad.example.code_smell.data_clumps.smell;

public class OrderProcessor {

	private String customerName;
	private String shippingAddress;
	private String billingAddress;

	public void processOrder() {
		System.out.println("Processing order for " + customerName);
		System.out.println("Shipping to:  " + shippingAddress);
		System.out.println("Billing to: " + billingAddress);
	}
}
