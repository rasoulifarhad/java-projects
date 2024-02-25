package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.polymorphic_behavior_through_interface;

public class TaxCalculatorUK implements TaxCalculator {

	@Override
	public double calculateTaxAmount() {
		return 2000;
	}

}
