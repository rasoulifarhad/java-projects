package com.farhad.example.design_principles02.implicit_dependencies;

import lombok.Getter;

@Getter
public class Customer {

	private String fullName;
	private String title;
	private String favoriteColor;

	public Customer(String fullName, String title, String favoriteColor) {
		this.fullName = fullName;
		this.title = title;
		this.favoriteColor = favoriteColor;
	}

}
