package com.farhad.example.design_principles02.shop_demo;

public class CustomerList {

	 
	private String name;

	public String findCustomer() {
		return name;
	}

	public void addCustomer(String name) {
		this.name = name;
	}
}
