package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.builder.better;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Person {

	private String firstName;
	private String lastName;
	private String city;
	private long aadharId;

	protected Person(PersonBuilder<?> builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.city = builder.city;
		this.aadharId = builder.aadharId;
	}

	public static class PersonBuilder<SELF extends PersonBuilder<SELF>> {
		private String firstName;
		private String lastName;
		private String city;
		private long aadharId;
		public PersonBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public SELF withCity(String city) {
			this.city = city;
			return (SELF)this;
		}

		public SELF withAadhar(long aadharId) {
			this.aadharId = aadharId;
			return (SELF)this;
		}

		public Person build() {
			Person person = new Person(this);
			return person;
		}
	}
}
