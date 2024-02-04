package com.farhad.example.design_principles02.ecommerce_system;

public class Configuration {

	public static TicketPrinter getSalesTicket() {
		return new HeaderDecorator(
				new HeaderDecorator2(
						new FooterDecorator2(
								new FooterDecorator(
										new SalesTicket()))));	}
}
