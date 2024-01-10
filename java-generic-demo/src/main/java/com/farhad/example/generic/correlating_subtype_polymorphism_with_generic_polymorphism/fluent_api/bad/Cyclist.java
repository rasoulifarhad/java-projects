package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.fluent_api.bad;

import lombok.Getter;

public class Cyclist extends Person{

	@Getter
	private String bikeName;
	
	public Cyclist withBikeName(String bikeName) {
		this.bikeName = bikeName;
		return this;
	}
}
