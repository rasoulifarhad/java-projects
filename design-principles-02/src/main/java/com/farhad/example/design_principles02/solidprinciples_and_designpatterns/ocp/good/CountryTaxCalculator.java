package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.ocp.good;

public interface CountryTaxCalculator {

	double calculateTaxAmount();

	void setTotalIncome(double amount);

	void setTotalDeduction(double deduction);

	double getTotalIncome();

	double getTotalDeduction();
}
