package com.farhad.example.OOADP_Lab.factory_method;

public class RCustomer implements Customer {

	@Override
	public void getType() {
		System.out.println("Regular Customer");
	}

}
