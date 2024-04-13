package com.farhad.example.design_principles02.video_store_demo.demo2.statement;

import com.farhad.example.design_principles02.video_store_demo.demo2.Customer;
import com.farhad.example.design_principles02.video_store_demo.demo2.Rental;

public class AsciiStatement extends Statement {

	public AsciiStatement(Customer customer) {
		super(customer);
	}

	@Override
	public String generate() {
		return header() + lineItems() + footer();
	}

	private String header() {
		return "Rental Record for " + customer.getName() + "\n";
	}

	private String lineItems() {
		String result = "";
		for (Rental rental : customer.getRentals()) {
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" +
			String.valueOf(rental.getCharge()) + "\n";
		}
		return result;
	}

	private String footer() {
		return totalCharge() + totalFrequentRenterPoints();
	}

	private String totalCharge() {
		return "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
	}

	private String totalFrequentRenterPoints() {
		return "You earned " + String.valueOf(
				getTotalFrequentRenterPoints()) +
				" frequent renter points";
	}



}
