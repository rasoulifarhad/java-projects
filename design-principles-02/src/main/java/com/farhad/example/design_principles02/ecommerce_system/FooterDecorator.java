package com.farhad.example.design_principles02.ecommerce_system;

public class FooterDecorator extends TicketDicoratore {

	public FooterDecorator(TicketPrinter ticketPrinter) {
		super(ticketPrinter);
	}

	@Override
	public void printTicket() {
		ticketPrinter.printTicket();
		printFooter();
	}

	private void printFooter() {
	}

}
