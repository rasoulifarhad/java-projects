package com.farhad.example.factory_beverage_machine;

public class Soda extends Beverage{

	private static Product product;
	
	public Soda(double price, int qty) {
		product = new Product("Soda", price, qty);
	}

	@Override
	public Product getFullProduct() {
		return product;
	}

}
