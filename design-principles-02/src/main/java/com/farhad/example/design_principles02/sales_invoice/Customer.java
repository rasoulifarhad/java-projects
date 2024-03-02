package com.farhad.example.design_principles02.sales_invoice;

import lombok.Data;

@Data
public class Customer {

	private int customerNumber;
	private String firstName;
	private String lastName;
	private Address address;
	private double creditLimit;
	private double creditBalance;
	public Customer(String firstName, String lastName, Address address, double creditLimit, double creditBalance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.creditLimit = creditLimit;
		this.creditBalance = creditBalance;

		this.customerNumber = CustomerDB.addToDatabase(this);
	}

	public Customer() {

	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
}
