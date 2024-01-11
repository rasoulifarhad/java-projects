package com.farhad.example.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo_02 {

	interface Money {}	

	interface Employee {
		Money getSalary();
	}

	interface Manager extends Employee {
	}
	
	interface Accountant extends Employee{}
	
	interface SoftwareEngineer extends Employee{}
	interface EmployeeService {
		Money calculateAvgSalary(Collection<Employee> employees);
	}

	interface EmployeeService02 {
		Money calculateAvgSalary(Collection<? extends Employee> employees);
	}

	public static void main(String[] args) {
		List<Manager> managers = new ArrayList<>();
		List<Accountant> accountants = new ArrayList<>();
		List<SoftwareEngineer> softwareEngineers = new ArrayList<>();

		EmployeeService employeeService = null;
		EmployeeService02 employeeService02 = null;

		// employeeService.calculateAvgSalary(managers);
		// employeeService.calculateAvgSalary(accountants);
		// employeeService.calculateAvgSalary(softwareEngineers);

		employeeService02.calculateAvgSalary(managers);
		employeeService02.calculateAvgSalary(accountants);
		employeeService02.calculateAvgSalary(softwareEngineers);
	}

}
