package com.farhad.example.factory_beverage_machine;

public class Coffee extends Beverage{

	private static Product product;
	
	public Coffee(double price, int qty) {
		product = new Product("Coffee", price, qty);
	}

	@Override
	public Product getFullProduct() {
		return product;
	}

}
