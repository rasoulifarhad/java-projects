package com.farhad.example.design_principles02.ecommerce_system;

public class UsTaxer implements TaxCalculator {

	private static UsTaxer instance;
	private double taxRate;
	private UsTaxer() {
		this.taxRate = 0.06;
	}

	public static synchronized UsTaxer getInstance() {
		if (instance == null) {
			instance = new UsTaxer();
		}
		return instance;
	}
	@Override
	public double taxAmount(Salable itemSold, int quantity) {
		return 0;
	}

}
