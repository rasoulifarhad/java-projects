package com.farhad.example.OOADP_Lab.strategy;

public class RCCustomer extends Customer {

	public RCCustomer(String id, String name) {
		super(id, name);
		this.discount = new RCDiscount();
		this.typeOfCust = "Regular Customer";
	}

}
