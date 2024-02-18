package com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.guitar;

import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Wood;

import lombok.Getter;

@Getter
public class GuitarSpec extends InstrumentSpec{ 

	private String numStrings;

	public GuitarSpec(Builder builder, String model, Type type, String numStrings, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
		this.numStrings = numStrings;
	}

	public boolean matches(GuitarSpec example) {
		// return this.equals(example);
		if (!super.matches(example)) {
			return false;
		}
		if (!(example instanceof GuitarSpec)) {
			return false;
		}
		GuitarSpec spec = (GuitarSpec) example;
		if (!numStrings.equals(spec.numStrings)) {
			return false;
		}
		return true;
	}

}
