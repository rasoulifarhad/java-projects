package com.farhad.example.OOADP_Lab.strategy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Customer {

	final String id;
	final String name;
	String typeOfCust;
	Discount discount;

	public void printBill(float amount) {
		System.out.println("\nID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Type of Customer: " + typeOfCust);
		System.out.println("Gross Amount: " + amount);
		System.out.println("Discount: " + discount.calcDiscount(amount));
		System.out.println("Amount Payable: " + (amount - discount.calcDiscount(amount)));

	}
	
}
