package com.farhad.example.design_principles02.ecommerce_system;

public class UseSalesOrder extends AbstractSalesOrder {

	@Override
	public double calcTax() {
		return Double.NaN;
	}

}
