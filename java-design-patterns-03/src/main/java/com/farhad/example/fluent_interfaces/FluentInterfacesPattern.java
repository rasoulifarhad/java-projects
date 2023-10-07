package com.farhad.example.fluent_interfaces;

public class FluentInterfacesPattern {
	
	public static void main(String[] args) {
		
		Order.place(order -> order
			.add("shoes")
			.add("Headphones").deliverAt("Street no XX, YYYY")
			.add("Airpods").deliverAt("another place")
		);
	}
}
