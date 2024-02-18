package com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.bass;

import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Wood;

public class BassSpec extends InstrumentSpec {

	public BassSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
	}

	public boolean matches(BassSpec example) {
		return super.matches(example);
	}

	
}
