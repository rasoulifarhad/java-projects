package com.farhad.example.design_principles02.video_store_demo.demo1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor
public abstract class Movie {

	
	private final String title;

	public abstract double getCharge(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);
}
