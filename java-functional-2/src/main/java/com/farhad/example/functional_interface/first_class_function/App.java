package com.farhad.example.functional_interface.first_class_function;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
			new Invoice(Customer.GOOGLE, "customer google"),
			new Invoice(Customer.GOOGLE, "Google Training"),
			new Invoice(Customer.FACEBOOK, "facebook Training"),
			new Invoice(Customer.ORACLE, "customer oracle Training"),
			new Invoice(Customer.FACEBOOK, "customer facebook"),
			new Invoice(Customer.FACEBOOK, "facebook Training"));

		App app = new App();

		List<Invoice> oracleInvoices = app.findInvoices(invoices, invoice -> invoice.getCustomer() == Customer.ORACLE );
		System.out.println("oracle invoices: " + oracleInvoices);

		List<Invoice> trainingInvoices = app.findInvoices(invoices, invoice -> invoice.getName().endsWith("Training") );
		System.out.println("training invoices: " + trainingInvoices);

		Predicate<Invoice> isFasebookInvoice = invoice -> invoice.getCustomer() == Customer.FACEBOOK;
		
		List<Invoice> facebookAndTraining = 
			invoices.stream()
				.filter(isFasebookInvoice.and(app::isTrainingInvoice))
				.collect(toList());
		System.out.println("Facebook trainings: " + facebookAndTraining);
		List<Invoice> facebookOrGoogle = 
			invoices.stream()
				.filter(isFasebookInvoice.or(app::isGoogleInvoice))
				.collect(toList());
		System.out.println("Facebook or Google: " + facebookOrGoogle);

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

	// modeling the filtering criterion
	// using different criterion with objects
	public List<Invoice> findInvoices(List<Invoice> invoices, Predicate<Invoice> p){
		List<Invoice> result = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if(p.test(invoice)) {
				result.add( invoice);
			}
		}
		return result;
	}

	class FacebookTraining implements Predicate<Invoice> {

		@Override
		public boolean test(Invoice t) {
			return t.getCustomer() == Customer.FACEBOOK;
		}
	}

	public List<Invoice> findInvoicesFromFacebook(List<Invoice> invoices){
		return findInvoices(invoices, new FacebookTraining());
	}

	// method reference

	public boolean isOracleInvoice(Invoice invoice) {
		return invoice.getCustomer() == Customer.ORACLE;
	}

	public boolean isGoogleInvoice(Invoice invoice) {
		return invoice.getCustomer() == Customer.GOOGLE;
	}

	public boolean isTrainingInvoice(Invoice invoice) {
		return invoice.getName().endsWith("Training");
	}

	public List<Invoice> findOracleInvoices(List<Invoice> invoices) {
		return findInvoices(invoices, this::isOracleInvoice);
	}

	public List<Invoice> findTrainingInvoices(List<Invoice> invoices) {
		return findInvoices(invoices, this::isTrainingInvoice);
	}


}
