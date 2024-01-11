package com.farhad.example.generic.emulating_self_types_with_generics;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

	private String department;

	public EmployeeBuilder withDepartment(String department) {
		this.department = department;
		return this;
	}

	public void build() {
		
	}
}
