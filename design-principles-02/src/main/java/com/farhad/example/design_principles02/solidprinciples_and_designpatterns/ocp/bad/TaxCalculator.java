package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.ocp.bad;

public class TaxCalculator {

	public double calculate(double income, double deduction, String country) {

		double taxAmount = 0;
		double taxableIncome = income - deduction;

		switch (country) {
			case "USA":
				taxAmount = income * 0.10;
				break;
			case "UK":
				taxAmount = income * 0.08;
				break;
			case "India":
				taxAmount = income * 0.09;
				break;

			default:
				throw new IllegalArgumentException("Unknown country: " + country);
		}
		return taxAmount;
	}
}
