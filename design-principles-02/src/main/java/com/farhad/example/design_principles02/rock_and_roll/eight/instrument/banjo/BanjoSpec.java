package com.farhad.example.design_principles02.rock_and_roll.eight.instrument.banjo;

import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.share.Wood;

import lombok.Getter;

@Getter
public class BanjoSpec extends InstrumentSpec {

	private int numStrings;

	public BanjoSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
		this.numStrings = numStrings;
	}

	public boolean matches(BanjoSpec example) {
		if (!super.matches(example)) {
			return false;
		}

		if (!(example instanceof BanjoSpec)) {
			return false;
		}

		BanjoSpec banjoSpec = (BanjoSpec) example;

		if (numStrings != banjoSpec.numStrings) {
			return false;
		}
		
		return true;
	}

	

}
