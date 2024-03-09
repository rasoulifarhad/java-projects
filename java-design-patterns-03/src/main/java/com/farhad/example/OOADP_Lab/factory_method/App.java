package com.farhad.example.OOADP_Lab.factory_method;

public class App {

	public static void main(String[] args) {
		
		CustomerFactory cf = new CustomerFactory();
		Customer customer = cf.getCustomer("senior citizen");

		customer.getType();
	}
}
