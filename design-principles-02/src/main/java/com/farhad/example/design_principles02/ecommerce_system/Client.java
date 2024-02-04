package com.farhad.example.design_principles02.ecommerce_system;

public class Client {

	public static void main(String[] args) {
		TicketPrinter ticketPrinter = Configuration.getSalesTicket();
		ticketPrinter.printTicket();
	}
}
