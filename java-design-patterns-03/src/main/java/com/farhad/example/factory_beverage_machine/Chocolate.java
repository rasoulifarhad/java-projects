package com.farhad.example.factory_beverage_machine;

public class Chocolate extends Beverage {

	private static Product product;

	public Chocolate(double price, int qty) {
		product = new Product("Chocolate", price, qty);
	}

	@Override
	public Product getFullProduct() {
		return product;
	}

}
