package com.farhad.example.design_principles02.ecommerce_system;

public class Configuration {

	public TicketPrinter getSalesTicket() {
		return new SalesTicket();
	}
}
