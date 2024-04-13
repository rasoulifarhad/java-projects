package com.farhad.example.design_principles02.video_store_demo;

import lombok.Data;

@Data
public class Rental {

	private Movie movie;
	private int daysRented;

}
