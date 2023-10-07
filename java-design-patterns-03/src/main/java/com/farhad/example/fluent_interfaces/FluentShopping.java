package com.farhad.example.fluent_interfaces;

public class FluentShopping {
	
	public static void main(String[] args) {
		
		Order myOrder = new Order();

		myOrder.add("shoes");
		myOrder.add("Headphones");
		myOrder.deliverAt("Street no XX, YYYY");
		myOrder.place();
	}
}
