package com.farhad.example.design_principles02.video_store_demo.demo2.statement;

import com.farhad.example.design_principles02.video_store_demo.demo2.Customer;
import com.farhad.example.design_principles02.video_store_demo.demo2.Rental;

public class AsciiStatement extends Statement {

	public AsciiStatement(Customer customer) {
		super(customer);
	}

	@Override
	public String generate() {
		String result = "Rental Record for " + customer.getName() + "\n";
		for (Rental rental : customer.getRentals()) {
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" +
			String.valueOf(rental.getCharge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(
				getTotalFrequentRenterPoints()) +
				" frequent renter points";
		return result;
	}

}
