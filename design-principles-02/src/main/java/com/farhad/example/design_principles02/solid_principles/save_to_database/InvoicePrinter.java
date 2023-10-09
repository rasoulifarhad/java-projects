package com.farhad.example.design_principles02.solid_principles.save_to_database;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoicePrinter {
	
	private final Invoice invoice;

	public void print() {
		System.out.println(invoice.getQuantity() + "x " + invoice.getBook().getName() + " " +          invoice.getBook().getPrice() + "$");
		System.out.println("Discount Rate: " + invoice.getDiscountRate());
		System.out.println("Tax Rate: " + invoice.getTaxRate());
		System.out.println("Total: " + invoice.getTotal());
	}	
}
