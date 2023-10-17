package com.farhad.example.functional_interface.first_class_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
		// abstracting the customer
	public List<Invoice> findInvoicesFromCustomer(List<Invoice> invoices, Customer customer){
		List<Invoice> result = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if(invoice.getCustomer() == customer) {
				result.add( invoice);
			}
		}
		return result;

	}


	public static void main(String[] args) {
		List<Invoice> invoices = Arrays.asList(
			new Invoice(Customer.ORACLE, "customer oracle"),
			new Invoice(Customer.IBM, "customer ibm"),
			new Invoice(Customer.GOOGLE, "customer ibm"),
			new Invoice(Customer.ORACLE, "customer oracle"));
	}

	// filtering invoices from oracle
	public List<Invoice> findInvoicesFromOracle(List<Invoice> invoices){
		List<Invoice> result = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if(invoice.getCustomer() == Customer.ORACLE) {
				result.add( invoice);
			}
		}
		return result;

	}


	// abstracting the name
	public List<Invoice> findInvoicesEndingWith(List<Invoice> invoices, String suffix){
		List<Invoice> result = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if(invoice.getName().endsWith(suffix)) {
				result.add( invoice);
			}
		}
		return result;

	}

	// messy code-reuse!
	public List<Invoice> findInvoices(List<Invoice> invoices, Customer customer, String suffix, boolean flag){
		List<Invoice> result = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if(	(flag && invoice.getCustomer() == customer) ||
				(!flag && invoice.getName().endsWith(suffix))) {
				result.add( invoice);
			}
		}
		return result;

	}



}
