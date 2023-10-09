package com.farhad.example.cascaded_builder;

public class App {
	
	public static void main(String[] args) {
		Delivery.deliver(
			delivery -> 
				delivery.firstname("first name")
						.lastname("last name")
						.address("that address")
						.content("that content"));
	}
}
