package com.farhad.example.design_principles02.ecommerce_system;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BetterSalesOrder {

	private TaxCalculator taxCalculator;

	private Customer customer;
	private List<Salable> items = new ArrayList<>();
	public double calcTax() {
		throw new UnsupportedOperationException("Unimplemented method 'taxAmount'");

	}
}
