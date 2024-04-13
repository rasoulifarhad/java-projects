package com.farhad.example.design_principles02.video_store_demo.demo2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Rental {

	private final Movie movie;

	@Getter
	private final int daysRented;

	public String getMovieTitle() {
		return movie.getTitle();
	}

	public double getCharge() {
		return movie.getCharge(getDaysRented());
	}

	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(getDaysRented());
	}
}
