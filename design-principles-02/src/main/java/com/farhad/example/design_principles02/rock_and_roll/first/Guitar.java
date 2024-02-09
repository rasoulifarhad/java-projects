package com.farhad.example.design_principles02.rock_and_roll.first;

import lombok.Data;

@Data
public class Guitar {

	private String serialNumbeer;

	private double price;
	private String builder;
	private String model;
	private String type;
	private String backWood;

	private String topWood;

	public Guitar(String serialNumbeer, double price, String builder, String model, String type, String backWood,
			String topWood) {
		this.serialNumbeer = serialNumbeer;
		this.price = price;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	
}
