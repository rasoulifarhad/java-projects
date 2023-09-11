package com.farhad.example.object_instantiation.constructors;

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
	
	public Person(String name) {
		this(name, Collections.emptyList(), null);
	}

	public Person(LocalDate birthDate) {
		this(null, Collections.emptyList(), birthDate);
	}

	public Person(String name, List<String> addresses) {
		this(name, addresses, null);
	}

	public Person(String name, List<String> addresses, LocalDate birthDate) {
		this.name = name;
		this.addresses = addresses;
		this.birthDate = birthDate;
	}

	public Integer calculateAgeFrom(LocalDate currentDate) {
		return Period.between(this.birthDate, currentDate).getYears();
	}
	
}
