package com.farhad.example.design_principles02.ecommerce_system;

import lombok.Data;

@Data
public class SalesTicketPrinter {

	private Header header;
	private Footer footer;

	private boolean printHeader = false;
	private boolean printFooter = false;
	public void printTicket() {
		
	}
}
