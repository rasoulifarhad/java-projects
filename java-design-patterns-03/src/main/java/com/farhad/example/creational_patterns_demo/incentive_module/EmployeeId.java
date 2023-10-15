package com.farhad.example.creational_patterns_demo.incentive_module;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Value
public class EmployeeId {
	
	private UUID uuid;

	public static EmployeeId newId() {
		return new EmployeeId(UUID.randomUUID());
	}

	public static EmployeeId from(String uuidString){
		return new EmployeeId(UUID.fromString(uuidString));
	}
}
