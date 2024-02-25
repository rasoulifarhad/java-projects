package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.ocp.good;

public class TaxCalculator {

	public double calculate(CountryTaxCalculator taxCalculator) {
		return taxCalculator.calculateTaxAmount();
	} 

}
