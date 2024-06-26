package com.farhad.example.design_principles02.ecommerce_system;

public class FooterDecorator extends TicketDecorator {

	public FooterDecorator(TicketPrinter ticketPrinter) {
		super(ticketPrinter);
	}

	@Override
	public void printTicket() {
		super.printTicket();
		// ticketPrinter.printTicket();
		printFooter();
	}

	private void printFooter() {
		System.out.println("%% FOOTER one %%");
	}

}
