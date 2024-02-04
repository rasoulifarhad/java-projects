package com.farhad.example.design_principles02.ecommerce_system;

public class HeaderDecorator extends TicketDicoratore {

	public HeaderDecorator(TicketPrinter ticketPrinter) {
		super(ticketPrinter);
	}

	@Override
	public void printTicket() {
		printHeader();
		ticketPrinter.printTicket();
	}

	private void printHeader() {
	}

}
