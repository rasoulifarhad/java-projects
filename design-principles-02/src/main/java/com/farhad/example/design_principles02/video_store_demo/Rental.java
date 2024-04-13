package com.farhad.example.design_principles02.video_store_demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Rental {

	double getCharge() {
		return movie.getCharge(daysRented);
	}

	int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}


	private final Movie movie;
	private final int daysRented;

}
