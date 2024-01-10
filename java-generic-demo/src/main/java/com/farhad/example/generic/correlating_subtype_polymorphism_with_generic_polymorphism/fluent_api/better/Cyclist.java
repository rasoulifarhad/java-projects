package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.fluent_api.better;

public class Cyclist extends Person<Cyclist>{

	private String bikeName;

	public Cyclist withBikeName(String bikeName) {
		this.bikeName = bikeName;
		return this;
	}
}
