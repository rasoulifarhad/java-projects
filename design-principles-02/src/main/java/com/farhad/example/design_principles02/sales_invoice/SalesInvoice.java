package com.farhad.example.design_principles02.sales_invoice;

import java.util.Date;

public class SalesInvoice {

	private Date invoiceDate;;
	private Customer soldTo;
	private Recipient recipient;
	private SalesPerson soldBy;
	private LineItems items;

	
	public SalesInvoice(Customer soldTo) {
		this.soldTo = soldTo;
	}

	public SalesInvoice() {
		this(new Customer(), null, new SalesPerson(), null);
		this.items = new LineItems(5, this);
		// this.soldTo = new Customer();
	}

	public SalesInvoice(int customerNumber) {

		this.soldTo = CustomerDB.getCustomer(customerNumber);
	}
	
	

	public SalesInvoice(Customer soldTo, Recipient recipient, SalesPerson soldBy, LineItems items) {
		this.soldTo = soldTo;
		this.recipient = recipient;
		this.soldBy = soldBy;
		this.items = items;
	}

	private double tax() {
		return 0;
	}
	public double totalDue() {
		return 0;
	}	
}
