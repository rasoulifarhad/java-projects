package com.farhad.example.design_principles02.ecommerce_system;

public class HeaderDecorator extends TicketDecorator {

	public HeaderDecorator(TicketPrinter ticketPrinter) {
		super(ticketPrinter);
	}

	@Override
	public void printTicket() {
		printHeader();
		// ticketPrinter.printTicket();
		super.printTicket();
	}

	private void printHeader() {
		System.out.println("@@ Header One @@");
	}

}
