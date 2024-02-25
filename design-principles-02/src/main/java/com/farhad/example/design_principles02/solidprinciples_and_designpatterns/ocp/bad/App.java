package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.ocp.bad;


public class App {

	public double calculateTax(IncomeDetails incomeDetails) {
		TaxCalculator taxCalculator = new TaxCalculator();
		return taxCalculator.calculate(incomeDetails.getTotalIncome(), incomeDetails.getTotalDeduction(),
				incomeDetails.getCountry());	
		
	}

}
