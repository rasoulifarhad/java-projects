package com.farhad.example.design_principles02.implicit_dependencies.explicit_dependencies;

import java.io.IOException;
import java.time.LocalTime;

public class App {

	public static void main(String[] args) throws IOException {
		
		Customer customer = new Customer("Boy", "Mr.", "blue");

		PersonalizedResponse response = new PersonalizedResponse(new SimpleFileLogger(), LocalTime.now());
		System.out.println(response.getResponse(customer)); 
	}
}
