package com.farhad.example.object_instantiation.builder;

public class PersonValidation {
	public boolean validate(Person person) {
		return person.getBirthDate() != null;
	}
	
}
