package com.farhad.example.design_principles02.ecommerce_system;

public class SalesTicket implements TicketPrinter {

	@Override
	public void printTicket() {
		System.out.println("Customer: XXXX");
		System.out.println("The sales ticket itself");
		System.out.println("Total: $123.45");		
	}

}
