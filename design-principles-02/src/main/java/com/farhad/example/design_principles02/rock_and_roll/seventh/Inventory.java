package com.farhad.example.design_principles02.rock_and_roll.seventh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.Instrument;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.banjo.Banjo;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.banjo.BanjoSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.bass.Bass;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.bass.BassSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.dobro.Dobro;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.dobro.DobroSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.fiddle.Fiddle;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.fiddle.FiddleSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.guitar.Guitar;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.guitar.GuitarSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.mandolin.Mandolin;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.mandolin.MandolinSpec;

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

	public List<Banjo> search(BanjoSpec exampleMandolin) {
		return instruments.stream()
				.filter(g -> g instanceof Banjo)
				.map(g -> (Banjo) g)
				.filter(g -> g.getSpec().matches(exampleMandolin))
				.collect(Collectors.toList());
	}

	public List<Bass> search(BassSpec exampleMandolin) {
		return instruments.stream()
				.filter(g -> g instanceof Bass)
				.map(g -> (Bass) g)
				.filter(g -> g.getSpec().matches(exampleMandolin))
				.collect(Collectors.toList());
	}

	public List<Dobro> search(DobroSpec exampleMandolin) {
		return instruments.stream()
				.filter(g -> g instanceof Dobro)
				.map(g -> (Dobro) g)
				.filter(g -> g.getSpec().matches(exampleMandolin))
				.collect(Collectors.toList());
	}

	public List<Fiddle> search(FiddleSpec exampleMandolin) {
		return instruments.stream()
				.filter(g -> g instanceof Fiddle)
				.map(g -> (Fiddle) g)
				.filter(g -> g.getSpec().matches(exampleMandolin))
				.collect(Collectors.toList());
	}

}
