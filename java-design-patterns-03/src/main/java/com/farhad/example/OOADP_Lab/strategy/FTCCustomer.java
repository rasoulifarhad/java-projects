package com.farhad.example.OOADP_Lab.strategy;

public class FTCCustomer extends Customer {

	public FTCCustomer(String id, String name) {
		super(id, name);
		this.discount = new FTCDiscount();
		this.typeOfCust = "First Time Customer";
	}


}
