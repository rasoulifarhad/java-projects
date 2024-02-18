package com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.dobro;

import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Wood;

public class DobroSpec extends InstrumentSpec{

	public DobroSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
	}

	public boolean matches(DobroSpec example) {
		return super.matches(example);
	}

	
}
