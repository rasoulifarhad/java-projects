package com.farhad.example.design_principles02.video_store_demo.demo2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Rental {

	private final Movie movie;
	private final int daysRented;
}
