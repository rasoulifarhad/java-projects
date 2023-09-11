package com.farhad.example.object_instantiation.constructors;

public class PersonValidation {
	public boolean validate(Person person) {
		return person.getBirthDate() != null;
	}

}
