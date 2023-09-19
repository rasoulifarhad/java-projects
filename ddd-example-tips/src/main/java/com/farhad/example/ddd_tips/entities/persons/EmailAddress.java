package com.farhad.example.ddd_tips.entities.persons;

import java.util.Objects;

import lombok.Value;

@Value
public class EmailAddress {
	private final String  email;

	public EmailAddress(String email) {
		this.email = Objects.requireNonNull(email);
	}

	
}
