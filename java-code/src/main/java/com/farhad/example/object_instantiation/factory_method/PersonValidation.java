package com.farhad.example.object_instantiation.factory_method;

public class PersonValidation {
	public boolean validate(Person person) {
		return person.getBirthDate() != null;
	}
}
