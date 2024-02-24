package com.farhad.example.design_principles02.polymorphic_behavior_through_interface;

public class TaxCalculatorForUs implements TaxCalculator {

	@Override
	public double calculateTaxAmount() {
		return 1000;
	}

}
