package com.farhad.example.OOADP_Lab.factory_method;

public class SCCustomer implements Customer {

	@Override
	public void getType() {
		System.out.println("Senior Citizen Customer");
	}

}
