package com.farhad.example.design_principles02.rock_and_roll.second;

import lombok.Data;

@Data
public class Guitar {

	private String serialNumbeer;

	private double price;
	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;

	private Wood topWood;

	public Guitar(String serialNumbeer, double price, Builder builder, String model, Type type, Wood backWood,
			Wood topWood) {
		this.serialNumbeer = serialNumbeer;
		this.price = price;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	
}
