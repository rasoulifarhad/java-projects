package com.farhad.example.design_principles02.ecommerce_system;

public class CanadianTaxer implements TaxCalculator {

	private static CanadianTaxer instance;
	private double taxRate;

	private CanadianTaxer() {
		this.taxRate = 0.06;
	}

	public static synchronized CanadianTaxer getInstance() {
		if (instance == null) {
			instance = new CanadianTaxer();
		}
		return instance;
	}

	@Override
	public double taxAmount(Salable itemSold, int quantity) {
		return 0;
	}

}
