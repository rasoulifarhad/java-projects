package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.fluent_api.bad;

public class App {

	public static void main(String[] args) {
		
		new Person().withName("name").withAge(20);
	}
}
