package com.farhad.example.code_smell.data_clumps.better;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderProcessing {

	private final CustomerInfo customerInfo;

	public void processOrder() {
		System.out.println("Processing order for " + customerInfo.getCustomerName());
		System.out.println("Shipping to:  " + customerInfo.getShippingAddress());
		System.out.println("Billing to: " + customerInfo.getBillingAddress());
	}

}
