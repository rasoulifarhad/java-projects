package com.farhad.example.ddd_tips.factories;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.Value;

public class Customer {

    public PostalCode postalCode() {
        return null;
    }

    public String streetAddress() {
        return null;
    }

    public String fullName() {
        return null;
    }

    public CustomerId id() {
        return null;
    }

    @RequiredArgsConstructor
	@Value
	public static class CustomerId {
		private final String id;

		public static CustomerId createRandomUnique() {
			return new CustomerId(UUID.randomUUID().toString());
		}

	}
}
