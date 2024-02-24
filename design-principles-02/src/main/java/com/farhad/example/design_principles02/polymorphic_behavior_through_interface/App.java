package com.farhad.example.design_principles02.polymorphic_behavior_through_interface;

public class App {

	public static void main(String[] args) {

		TaxCalculator taxCalculator = new TaxCalculatorForUs();
		showDetails(taxCalculator);

		taxCalculator = new TaxCalculatorUK();
		showDetails(taxCalculator);
	}
	
	public static void showDetails(TaxCalculator tc) {

		System.out.println("Tax amount: " + tc.calculateTaxAmount());
	}
}
