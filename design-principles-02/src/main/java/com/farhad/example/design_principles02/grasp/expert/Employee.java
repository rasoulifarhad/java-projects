package com.farhad.example.design_principles02.grasp.expert;

public class Employee {

	private double baseSalary;
	private double hourseWorked;
	private double bonus;
	private double hourlyRate;

	public double calculateSalary() {
		return baseSalary + (hourseWorked * hourlyRate) + bonus;
	}
}
