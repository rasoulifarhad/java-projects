package com.farhad.example.OOADP_Lab.factory_method;

public class FTCustomer implements Customer {

	@Override
	public void getType() {
		System.out.println("First Time Customer");
	}

}
