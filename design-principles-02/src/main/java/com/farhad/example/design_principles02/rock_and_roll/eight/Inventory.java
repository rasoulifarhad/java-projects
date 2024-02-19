package com.farhad.example.design_principles02.rock_and_roll.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.Instrument;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.banjo.Banjo;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.banjo.BanjoSpec;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.bass.Bass;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.bass.BassSpec;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.dobro.Dobro;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.dobro.DobroSpec;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.fiddle.Fiddle;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.fiddle.FiddleSpec;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.guitar.Guitar;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.guitar.GuitarSpec;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.mandolin.Mandolin;
import com.farhad.example.design_principles02.rock_and_roll.eight.instrument.mandolin.MandolinSpec;

public class Inventory {

	private List<? super Instrument> instruments = new ArrayList<>();

	public Instrument get(String serialNumber) {
		return instruments.stream()
				.map(g -> (Instrument) g)
				.filter((Instrument g) -> g.getSerialNumbeer().equals(serialNumber))
				.findFirst()
				.orElse(null);
	}

	public void addInstrument(String serialNumbeer, double price, InstrumentSpec spec) {
		if (spec instanceof GuitarSpec) {
			addGuitar(serialNumbeer, price, spec);
		} else if (spec instanceof MandolinSpec) {
			addMandolin(serialNumbeer, price, spec);
		} else if (spec instanceof BanjoSpec) {
			addBanjo(serialNumbeer, price, spec);
		} else if (spec instanceof BassSpec) {
			addBass(serialNumbeer, price, spec);
		} else if (spec instanceof DobroSpec) {
			addDobro(serialNumbeer, price, spec);
		} else if (spec instanceof FiddleSpec) {
			addFiddle(serialNumbeer, price, spec);
		} else {
			throw new IllegalArgumentException("Unknown spec data: " + spec.getClass());
		}
	}

	private void addGuitar(String serialNumbeer, double price, InstrumentSpec spec) {
		instruments.add(new Guitar(serialNumbeer, price, (GuitarSpec)spec));
	}

	private void addMandolin(String serialNumbeer, double price, InstrumentSpec spec) {
		instruments.add(new Mandolin(serialNumbeer, price, (MandolinSpec)spec));
	}
	
	private void addBanjo(String serialNumbeer, double price, InstrumentSpec spec) {
		instruments.add(new Banjo(serialNumbeer, price, (BanjoSpec) spec));
	}

	private void addBass(String serialNumbeer, double price, InstrumentSpec spec) {
		instruments.add(new Bass(serialNumbeer, price, (BassSpec) spec));
	}

	private void addDobro(String serialNumbeer, double price, InstrumentSpec spec) {
		instruments.add(new Dobro(serialNumbeer, price, (DobroSpec) spec));
	}

	private void addFiddle(String serialNumbeer, double price, InstrumentSpec spec) {
		instruments.add(new Fiddle(serialNumbeer, price, (FiddleSpec) spec));
	}

	public List<? extends Instrument> search(InstrumentSpec exampleSpec) {
		return instruments.stream()
				.map(i -> (Instrument) i)
				.filter(g -> g.getSpec().matches(exampleSpec))
				.collect(Collectors.toList());
	}

}
