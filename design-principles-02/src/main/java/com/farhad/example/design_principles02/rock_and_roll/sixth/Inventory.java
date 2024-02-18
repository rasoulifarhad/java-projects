package com.farhad.example.design_principles02.rock_and_roll.sixth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	

	public List<Guitar> search(GuitarSpec exampleGuitar) {
		return instruments.stream()
				.filter(i -> i instanceof Guitar)
				.map(i -> (Guitar) i)
				.filter(g -> g.getSpec().matches(exampleGuitar))
				.collect(Collectors.toList());
	}

	public List<Mandolin> search(MandolinSpec exampleMandolin) {
		return instruments.stream()
				.filter(g -> g instanceof Mandolin)
				.map(g -> (Mandolin) g)
				.filter(g -> g.getSpec().matches(exampleMandolin))
				.collect(Collectors.toList());
	}
}
