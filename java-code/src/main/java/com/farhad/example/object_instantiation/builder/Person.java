package com.farhad.example.object_instantiation.builder;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class Person {
	private final String name;
	@Singular
	private final List<String> addresses;
	private final LocalDate birthDate;
	
	private Person(String name, List<String> addresses, LocalDate birthDate) {
		this.name = name;
		this.addresses = Collections.unmodifiableList(addresses);
		this.birthDate = birthDate;
	}
	
	public Integer calculateAgeFrom(LocalDate currentDate) {
		return Period.between(this.birthDate, currentDate).getYears();
	}
}
