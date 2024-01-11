package com.farhad.example.generic;

import java.util.ArrayList;
import java.util.List;

public class Demo_04 {

	interface Employee {

	}

	interface Manager extends Employee {
	}

	interface Accountant extends Employee {
	}

	interface SoftwareEngineer extends Employee {
	}

	interface EmployeeRepository {
		List<? extends Employee> findEmployeesByNameLike(String nameLike);
	}

	public static void main(String[] args) {
		EmployeeRepository employeeRepository = null;

		// // compile error
		// List<Employee> employees = employeeRepository.findEmployeesByNameLike("nameLike");
		Manager manager01;
		Accountant accountant01;

		List<? extends Employee> employees = employeeRepository.findEmployeesByNameLike("nameLike");
		// employees.add(manager01); // compile error
		// employees.add(accountant01); // compile error
		employees.add(null);

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		List<? extends Employee> accountants = new ArrayList<Accountant>();
		List<? extends Employee> managers = new ArrayList<Manager>();
		List<? extends Employee> engineers = new ArrayList<SoftwareEngineer>();
	} 

}
