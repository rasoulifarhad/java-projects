package com.farhad.example.design_principles02.ecommerce_system;

public class CanadianSalesOrder extends SalesOrder {

	// canadian tax rules
	@Override
	public double calcTax() {
		return Double.NaN;
	}

	
}
