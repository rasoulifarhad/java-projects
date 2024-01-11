package com.farhad.example.generic.emulating_self_types_with_generics;

public class Person extends Object<Person>{

	@Override
	protected Person clone() {
		// no cast required because, THIS was specified as Person
		Person person = super.clone();
		return person;
	}

	
}
