package com.farhad.example.creational_patterns_demo.incentive_module;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Value
public class EmployId {
	
	private UUID uuid;

	public static EmployId newId() {
		return new EmployId(UUID.randomUUID());
	}

	public static EmployId from(String uuidString){
		return new EmployId(UUID.fromString(uuidString));
	}
}
