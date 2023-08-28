package com.farhad.example.designpatterns.separatedinterface.impl;

import com.farhad.example.designpatterns.separatedinterface.SeparatedInterfaceDemo.TaxCalculator;

public class ForeignTaxCalculator implements TaxCalculator{

	public static final double TAX_PRECENTAGE = 60;

	@Override
	public double calculate(double amount) {
		return amount * TAX_PRECENTAGE / 100.0;
	}
	
}
