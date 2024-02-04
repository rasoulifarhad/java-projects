package com.farhad.example.design_principles02.ecommerce_system;

public class HeaderDecorator2 extends TicketDecorator {

	public HeaderDecorator2(TicketPrinter ticketPrinter) {
		super(ticketPrinter);
	}

	@Override
	public void printTicket() {
		printHeader();
		// ticketPrinter.printTicket();
		super.printTicket();
	}

	private void printHeader() {
		System.out.println("@@ Header two @@");
	}

}
