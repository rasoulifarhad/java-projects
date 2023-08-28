package com.farhad.example.designpatterns.separatedinterface;

import lombok.RequiredArgsConstructor;

public class SeparatedInterfaceDemo {
	
	@RequiredArgsConstructor
	static class InvoiceGenerator {
		private final double amount;
		private final TaxCalculator taxCalculator;

		public double getAmountWithTax(){
			return amount + taxCalculator.calculate(amount);
		}
	}

	public interface TaxCalculator {
		double calculate(double amount);
	}
}
