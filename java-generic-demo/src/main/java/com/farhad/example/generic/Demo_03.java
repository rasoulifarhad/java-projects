package com.farhad.example.generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo_03 {

	interface Employee {

	}

	interface Manager extends Employee {
	}
	
	
	interface Accountant extends Employee {
	}

	interface SoftwareEngineer extends Employee {
	}
	
	interface SortingService {
		<T> void sort(List<T> list, Comparator<T> comparator);
	}

	interface SortingService02 {
		<T> void sort(List<T> list, Comparator<? super T> comparator);
	}

	interface SortingService03<T> {
		void sort(List<? extends T> list, Comparator<? super T> comparator);
	}
	public static void main(String[] args) {
		Comparator<Employee> comparator = null;

		List<Manager> managers = new ArrayList<>();
		List<Accountant> accountants = new ArrayList<>();
		List<SoftwareEngineer> softwareEngineers = new ArrayList<>();

		SortingService sortingService = null;
		SortingService02 sortingService02 = null;

		// sortingService.sort(managers, comparator);
		// sortingService.sort(accountants, comparator);
		// sortingService.sort(softwareEngineers, comparator);

		sortingService02.sort(managers, comparator);
		sortingService02.sort(accountants, comparator);
		sortingService02.sort(softwareEngineers, comparator);

	}
}
