package com.farhad.example.design_principles02.shop_demo;

public abstract class Shop {

	protected CustomerList customerList;

	public void calculateSaleTax() {
		System.out.println("Calculate sales tax");
	}
	public abstract String[] getInventory();

	public abstract void buyInventory(String item);
}
