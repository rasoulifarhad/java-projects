package com.farhad.example.design_principles02.video_store_demo;

import lombok.Data;

@Data
public class Rental {

	double getCharge() {
		double thisAmount = 0;
		switch (getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (getDaysRented() > 2) {
					thisAmount += (getDaysRented() - 2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += getDaysRented() * 3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if (getDaysRented() > 3) {
					thisAmount += (getDaysRented() - 3) * 1.5;
				}
				break;
	
			default:
				break;
		}
		return thisAmount;
	}
	private Movie movie;
	private int daysRented;

}