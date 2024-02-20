package com.farhad.example.design_principles02.rock_and_roll.tenth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.Instrument;
import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.InstrumentSpec;

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
		instruments.add(new Instrument(serialNumbeer, price, spec));
	}

	public List<? extends Instrument> search(InstrumentSpec exampleSpec) {
		return instruments.stream()
				.map(i -> (Instrument) i)
				.filter(g -> g.getSpec().matches(exampleSpec))
				.collect(Collectors.toList());
	}

}
