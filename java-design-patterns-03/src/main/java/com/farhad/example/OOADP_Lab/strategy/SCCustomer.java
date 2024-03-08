package com.farhad.example.OOADP_Lab.strategy;

public class SCCustomer extends Customer {

	public SCCustomer(String id, String name) {
		super(id, name);
		this.discount = new SCDiscount();
		this.typeOfCust = "Senior Customer";
	}

}
