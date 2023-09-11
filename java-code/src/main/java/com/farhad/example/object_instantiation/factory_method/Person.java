package com.farhad.example.object_instantiation.factory_method;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;

import lombok.Data;

@Data
public class Person {
	private final String name;
	private final List<String> addresses;
	private final LocalDate birthDate;
	
	private Person(String name, List<String> addresses, LocalDate birthDate) {
		this.name = name;
		this.addresses = Collections.unmodifiableList(addresses);
		this.birthDate = birthDate;
	}

	public static Person newPersonWithBirthDate(LocalDate birthDate) {
		return new Person(null, Collections.emptyList(), birthDate);
	}

	public static Person newPersonWithName(String name) {
		return new Person(name, Collections.emptyList(), null);
	}

	public static Person newPersonWithNameAndAddress(String name, List<String> addresses) {
		return new Person(name, addresses, null);
	}

	public static Person newFullPerson(String name, List<String> addresses, LocalDate birthDate) {
		return new Person(name, addresses, birthDate);
	}

	public Integer calculateAgeFrom(LocalDate currentDate) {
		return Period.between(birthDate, currentDate).getYears();
	}
	
}
