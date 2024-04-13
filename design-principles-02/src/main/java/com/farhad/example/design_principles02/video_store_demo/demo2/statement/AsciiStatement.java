package com.farhad.example.design_principles02.video_store_demo.demo2.statement;

import java.util.List;

import com.farhad.example.design_principles02.video_store_demo.demo2.Customer;
import com.farhad.example.design_principles02.video_store_demo.demo2.Rental;

public class AsciiStatement extends Statement {

	public AsciiStatement(Customer customer) {
		super(customer);
	}

	@Override
	public String generate() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		List<Rental> rentals = customer.getRentals();
		String result = "Rental Record for " + customer.getName() + "\n";
		for (Rental rental : rentals) {

			double thisAmount = rental.getCharge();

			frequentRenterPoints += rental.getFrequentRenterPoints();
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) +
				" frequent renter points";
		return result;
	}

}
