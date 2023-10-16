package com.farhad.example.creational_patterns_demo.incentive_module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Factory {

	private final EmployeeId id;

	public KPI createKPIOfType(String type) {
		return null;
	}
}
