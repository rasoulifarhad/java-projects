package com.farhad.example.design_principles02.video_store_demo;

import lombok.Data;

@Data
public class Rental {

	double getCharge() {
		return movie.getCharge(daysRented);
	}

	int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}
	private Movie movie;
	private int daysRented;

}
