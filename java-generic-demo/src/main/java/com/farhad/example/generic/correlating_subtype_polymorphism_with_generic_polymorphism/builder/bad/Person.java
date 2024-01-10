package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.builder.bad;

import lombok.Getter;

@Getter
public class Person {

	private String firstName;
	private String lastName;
	private String city;
	private long aadharId;

	public Person(String firstName, String lastName) {
		this(firstName, lastName, "City not Known", -1);
	}
	public Person(String firstName, String lastName, String city, long aadharId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.aadharId = aadharId;
	}
	public Person(String firstName, String lastName, String city) {
		this(firstName, lastName, city, -1);
	}
	public Person(String firstName, String lastName, long aadharId) {
		this(firstName, lastName, "City not Known", aadharId);
	}

	
	
	
}
