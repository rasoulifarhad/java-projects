package com.farhad.example.design_principles02.video_store_demo.demo2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Customer {

	@Getter
	private final String name;
	private List<Rental> rentals = new ArrayList<>();

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental rental : rentals) {
			
			double thisAmount = 0;

			// determine amount for rental line
			switch (rental.getMovie().getPriceCode()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (rental.getDaysRented() > 2)
						thisAmount += (rental.getDaysRented() - 2) * 1.5;
					break;
				case Movie.NEW_RELEASE:
					thisAmount += rental.getDaysRented() * 3;
					break;
				case Movie.CHILDRENS:
					thisAmount += 1.5;
					if (rental.getDaysRented() > 3)
						thisAmount += (rental.getDaysRented() - 3) * 1.5;
					break;
			}

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
					rental.getDaysRented() > 1)
				frequentRenterPoints++;

			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) +
				" frequent renter points";
		return result;
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
	}

}
