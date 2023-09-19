package com.farhad.example.ddd_tips.entities.persons;

import java.util.Objects;

import lombok.Value;

@Value

public class PersonName {
	private final String name;

	public PersonName(String name) {
		this.name = Objects.requireNonNull(name);
	}

	
}
