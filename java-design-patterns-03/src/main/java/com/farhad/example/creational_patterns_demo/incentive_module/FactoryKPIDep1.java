package com.farhad.example.creational_patterns_demo.incentive_module;

public class FactoryKPIDep1 extends Factory {

	
	public FactoryKPIDep1(EmployeeId id) {
		super(id);
	}

	@Override
	public KPI createKPIOfType(String type) {
		throw new UnsupportedOperationException("Unimplemented method 'createKPIOfType'");
	}
}
