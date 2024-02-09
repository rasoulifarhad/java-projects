package com.farhad.example.design_principles02.rock_and_roll.second;

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
		guitars.add(new Guitar(serialNumbeer, price, builder, model, type, backWood, topWood));
	}

	public List<Guitar> search(Guitar exampleGuitar) {
		return guitars.stream()
				.filter(g -> matched(exampleGuitar).test(g))
				.collect(Collectors.toList());
	}

	private Predicate<Guitar> matched(Guitar exampleGuitar) {
		return g -> {
			if (exampleGuitar.getBuilder() != g.getBuilder()) {
				return false;
			}
			String model = exampleGuitar.getModel();
			if ((model != null) && (!model.equals("")) && (!model.toLowerCase().equals(g.getModel().toLowerCase()))) {
				return false;
			}
			if (exampleGuitar.getType() != g.getType()) {
				return false;
			}
			if (exampleGuitar.getBackWood() != g.getBackWood()) {
				return false;
			}
			if (exampleGuitar.getTopWood() != g.getTopWood()) {
				return false;
			}
			return true;

		};
	}
}
