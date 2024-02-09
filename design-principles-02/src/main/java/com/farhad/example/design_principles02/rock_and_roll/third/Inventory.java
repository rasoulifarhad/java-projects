package com.farhad.example.design_principles02.rock_and_roll.third;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Inventory {

	private List<Guitar> guitars = new ArrayList<>();

	public Guitar geGuitar(String serialNumber) {
		return guitars.stream()
				.filter(g -> g.getSerialNumbeer().equals(serialNumber))
				.findFirst()
				.orElse(null);
	}

	public void addGuitar(String serialNumbeer, double price, Builder builder, String model, Type type,
			Wood backWood,
			Wood topWood) {
		guitars.add(new Guitar(serialNumbeer, price, new GuitarSpec(builder, model, type, backWood, topWood)));
	}

	public List<Guitar> search(GuitarSpec exampleGuitar) {
		return guitars.stream()
				.filter(g -> matched(exampleGuitar).test(g))
				.collect(Collectors.toList());
	}

	private Predicate<Guitar> matched(GuitarSpec exampleGuitar) {
		return g -> {
			if (exampleGuitar.getBuilder() != g.getGuitarSpec().getBuilder()) {
				return false;
			}
			String model = exampleGuitar.getModel();
			if ((model != null) && (!model.equals("")) && (!model.toLowerCase().equals(g.getGuitarSpec()
					.getModel().toLowerCase()))) {
				return false;
			}
			if (exampleGuitar.getType() != g.getGuitarSpec().getType()) {
				return false;
			}
			if (exampleGuitar.getBackWood() != g.getGuitarSpec().getBackWood()) {
				return false;
			}
			if (exampleGuitar.getTopWood() != g.getGuitarSpec().getTopWood()) {
				return false;
			}
			return true;

		};
	}
}
