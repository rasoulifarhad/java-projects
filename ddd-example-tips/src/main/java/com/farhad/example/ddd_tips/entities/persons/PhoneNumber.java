package com.farhad.example.ddd_tips.entities.persons;

import java.util.Objects;

import lombok.Value;

@Value
public class PhoneNumber {
	private final String value;

	public PhoneNumber(String value) {
		this.value = Objects.requireNonNull(value);
	}

	
}
