package com.farhad.example.design_principles02.rock_and_roll.fourth;

import lombok.Data;

@Data
public class GuitarSpec {

	private String numStrings;
	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood; 

	private Wood topWood;

	public GuitarSpec(String numStrings, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		this.numStrings = numStrings;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	
}
