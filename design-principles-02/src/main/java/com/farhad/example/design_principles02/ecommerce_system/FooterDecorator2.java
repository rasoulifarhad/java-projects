package com.farhad.example.design_principles02.ecommerce_system;

public class FooterDecorator2 extends TicketDecorator {

	public FooterDecorator2(TicketPrinter ticketPrinter) {
		super(ticketPrinter);
	}

	@Override
	public void printTicket() {
		super.printTicket();
		// ticketPrinter.printTicket();
		printFooter();
	}

	private void printFooter() {
		System.out.println("%% FOOTER two %%");
	}

}
