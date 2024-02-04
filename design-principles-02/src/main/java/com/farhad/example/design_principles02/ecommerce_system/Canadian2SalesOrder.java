package com.farhad.example.design_principles02.ecommerce_system;

public class Canadian2SalesOrder extends AbstractSalesOrder {

	@Override
	public double calcTax() {
		return Double.NaN;
	}

}
