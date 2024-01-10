package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.builder.better;

import org.junit.jupiter.api.Test;

import com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.builder.better.Person.PersonBuilder;

public class PersonTest {

	@Test
	public void personBuilderTest() {
		PersonBuilder builder = new PersonBuilder("first", "last");
		Person person = builder.withCity("city").build();
		System.out.println(person);
	}
}
