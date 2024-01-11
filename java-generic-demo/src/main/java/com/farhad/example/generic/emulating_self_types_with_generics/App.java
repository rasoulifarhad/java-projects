package com.farhad.example.generic.emulating_self_types_with_generics;

public class App {

	public static void main(String[] args) {
		
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		employeeBuilder.withName("name").withDepartment("Department").build();

		
	}
}
