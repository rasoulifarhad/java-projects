package com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.fiddle;

import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Wood;

import lombok.Getter;

@Getter
public class FiddleSpec extends InstrumentSpec {

	private String finish;

	public FiddleSpec(Builder builder, String model, Type type, String finish, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
		this.finish = finish;
	}

	public boolean matches(FiddleSpec example) {
		if (!super.matches(example)) {
			return false;
		}

		if (!(example instanceof FiddleSpec)) {
			return false;
		}

		FiddleSpec fiddleSpec = (FiddleSpec) example;

		if (!(finish.equals(fiddleSpec.finish))) {
			return false;
		}
		return true;
	}

	

}
