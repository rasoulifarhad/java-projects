package com.farhad.example.design_principles02.rock_and_roll.eighth.instrument;

import com.farhad.example.design_principles02.rock_and_roll.eighth.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.eighth.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.eighth.instrument.share.Wood;

import lombok.Getter;

@Getter
public class InstrumentSpec {

	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;

	private Wood topWood;

	public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public boolean matches(InstrumentSpec example) {
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
