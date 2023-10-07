package com.farhad.example.ddd_tips.specifications;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Data
public class Customer {
	private CustomerId id;
	private String name;
	private int age;
	private long balance;
	private String location;

	@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
	@Value
	public static class CustomerId {

		private final String uuid;

		public static CustomerId newId() {
			return new CustomerId(UUID.randomUUID().toString());
		}

		public static CustomerId from(String uuid) {
			return new CustomerId(UUID.fromString(uuid).toString());
		}
	}
}
