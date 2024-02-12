package com.farhad.example.design_principles02.rock_and_roll.fifth;

import lombok.Data;

@Data
public class GuitarSpec { 

	private Builder builder;
	private String model;
	private Type type;
	private String numStrings;
	private Wood backWood; 

	private Wood topWood;

	public GuitarSpec(Builder builder, String model, Type type, String numStrings, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.numStrings = numStrings;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public boolean matches(GuitarSpec example) {
		// return this.equals(example);

		if (this.getBuilder() != example.getBuilder()) {
			return false;
		}
		String model = this.getModel();
		if ((model != null) && (!model.equals("")) && (!model.toLowerCase().equals(example.getModel().toLowerCase()))) {
			return false;
		}
		if (this.getType() != example.getType()) {
			return false;
		}
		if (this.getBackWood() != example.getBackWood()) {
			return false;
		}
		if (this.getTopWood() != example.getTopWood()) {
			return false;
		}
		return true;

	}

}
