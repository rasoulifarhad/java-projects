package com.farhad.example.design_principles02.video_store_demo.demo2.price;

public class NewReleasePrice extends Price {

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}

	

}
