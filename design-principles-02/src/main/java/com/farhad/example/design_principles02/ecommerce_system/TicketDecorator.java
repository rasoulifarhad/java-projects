package com.farhad.example.design_principles02.ecommerce_system;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor	
public abstract class TicketDecorator implements TicketPrinter {

	protected TicketPrinter ticketPrinter;

	@Override
	public void printTicket() {
		if (ticketPrinter != null) {
			ticketPrinter.printTicket();
		}
	}

}
