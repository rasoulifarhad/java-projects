package com.farhad.example.designpatterns.separatedinterface;

import com.farhad.example.designpatterns.separatedinterface.SeparatedInterfaceDemo.InvoiceGenerator;
import com.farhad.example.designpatterns.separatedinterface.impl.DomesticTaxCalculator;
import com.farhad.example.designpatterns.separatedinterface.impl.ForeignTaxCalculator;

public class App {
	
	private final static double PRODUCT_CUST = 1000.0;

	public static void main(String[] args) {
		
		InvoiceGenerator internationalProductInvoice = new InvoiceGenerator(PRODUCT_CUST, new ForeignTaxCalculator());
		System.out.println("Foreign Tax applied: " + internationalProductInvoice.getAmountWithTax());
		InvoiceGenerator domesticProductInvoice = new InvoiceGenerator(PRODUCT_CUST, new DomesticTaxCalculator());
		System.out.println("Domestic Tax applied: " + domesticProductInvoice.getAmountWithTax());
	}
}