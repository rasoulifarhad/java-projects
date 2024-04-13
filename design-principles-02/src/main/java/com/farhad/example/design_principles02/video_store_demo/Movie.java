package com.farhad.example.design_principles02.video_store_demo;

import lombok.Data;

@Data
public class Movie {

	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 2;
	public static final int CHILDREN = 3;

	private String title;
	private int priceCode;
}
