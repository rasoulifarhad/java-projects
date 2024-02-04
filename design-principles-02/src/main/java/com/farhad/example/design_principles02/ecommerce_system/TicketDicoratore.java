package com.farhad.example.design_principles02.ecommerce_system;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor	
public abstract class TicketDicoratore implements TicketPrinter {

	protected TicketPrinter ticketPrinter;

	@Override
	public abstract void printTicket();

}
