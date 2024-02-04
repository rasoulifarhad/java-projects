package com.farhad.example.design_principles02.ecommerce_system;

// Responsibilities:
//
// - allow users to make an order using GUI
// - process the order
// - print a sales receipt
public class SalesOrder {

	private SalesTicketPrinter salesTicketPrinter;
	
	// us tax rules
	public double calcTax() {
		return Double.NaN;
	}
}
