package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.fluent_api.better;

public class App {

	public static void main(String[] args) {
		new Cyclist().withName("name").withAge(20).withBikeName("bikeName");
	}
}
