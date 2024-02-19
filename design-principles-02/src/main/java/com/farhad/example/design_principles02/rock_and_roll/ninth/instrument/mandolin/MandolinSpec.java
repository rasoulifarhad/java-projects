package com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.mandolin;

import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.share.Wood;

import lombok.Getter;

@Getter
public class MandolinSpec extends InstrumentSpec {

	private Style style;

	public MandolinSpec(Builder builder, String model, Type type, Style style, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
		this.style = style;
	}

	public boolean matches(MandolinSpec example) {
		if (!super.matches(example)) {
			return false;
		}

		if (!(example instanceof MandolinSpec)) {
			return false;
		}
		
		MandolinSpec spec = (MandolinSpec) example;

		if (!style.equals(spec.style)) {
			return false;
		}
		return true;
	}
	
}
