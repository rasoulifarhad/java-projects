package com.farhad.example.design_principles02.implicit_dependencies;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		Customer customer = new Customer("Boy", "Mr.", "blue");
		Context.setCurrentCustomer(customer);

		PersonalizedResponse response = new PersonalizedResponse();
		System.out.println(response.getResponse()); 
	}
}
