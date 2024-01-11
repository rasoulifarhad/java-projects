package com.farhad.example.generic;

import java.util.ArrayList;
import java.util.List;

public class Demo_05 {

	interface Employee {

	}

	interface Manager extends Employee {
	}

	interface Accountant extends Employee {
	}

	interface SoftwareEngineer extends Employee {
	}

	static class ManagerImpl implements Manager {
	}

	static class AccountantImpl implements Accountant {
	}
	static class SoftwareEngineerImpl implements SoftwareEngineer{}

	public static void main(String[] args) {
		
		List<? super Employee> employees = new ArrayList<>();

		Manager manager01 = new ManagerImpl();
		Accountant accountant01 = new AccountantImpl();
		SoftwareEngineer softwareEngineer01 = new SoftwareEngineerImpl();

		employees.add(manager01);
		employees.add(accountant01);
		employees.add(softwareEngineer01);
		employees.add(new Employee() {
		});
		// employees.add(new Object()); // compile error

		List<? super Employee> employees2 = new ArrayList<Employee>();
		List<? super Employee> employees3 = new ArrayList<Object>();
		// List<? super Employee> employees4 = new ArrayList<>(Manager); // compile error

		// // compile error
		// for (Employee employee : employees) {
		// 	System.out.println(employee);
		// }

 	}

}
