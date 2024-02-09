package com.farhad.example.design_principles02.rock_and_roll.first;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Inventory {

	private List<Guitar> guitars = new ArrayList<>();

	public Guitar geGuitar(String serialNumber) {
		return guitars.stream()
				.filter(g -> g.getSerialNumbeer().equals(serialNumber))
				.findFirst()
				.orElse(null);
	}

	public void addGuitar(String serialNumbeer, double price, String builder, String model, String type,
			String backWood,
			String topWood) {
		guitars.add(new Guitar(serialNumbeer, price, builder, model, type, backWood, topWood));
	}

	public Guitar search(Guitar exampleGuitar) {
		return guitars.stream()
				.filter(g -> matched(exampleGuitar).test(g))
				.findFirst()
				.orElse(null);
	}

	private Predicate<Guitar> matched(Guitar exampleGuitar) {
		return g -> {
			String builder = exampleGuitar.getBuilder();
			if ((builder != null) && (!builder.equals("")) && (!builder.equals(g.getBuilder()))) {
				return false;
			}
			String model = exampleGuitar.getModel();
			if ((model != null) && (!model.equals("")) && (!model.equals(g.getModel()))) {
				return false;
			}
			String type = exampleGuitar.getType();
			if ((type != null) && (!type.equals("")) && (!type.equals(g.getType()))) {
				return false;
			}
			String backWood = exampleGuitar.getBackWood();
			if ((backWood != null) && (!backWood.equals("")) && (!backWood.equals(g.getBackWood()))) {
				return false;
			}
			String topWood = exampleGuitar.getTopWood();
			if ((topWood != null) && (!topWood.equals("")) && (!topWood.equals(g.getTopWood()))) {
				return false;
			}
			return true;

		};
	}
}
