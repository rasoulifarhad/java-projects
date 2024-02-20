package com.farhad.example.design_principles02.rock_and_roll.tenth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.Instrument;
import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.InstrumentType;
import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.tenth.instrument.share.Wood;

public class FindInstrument {
	
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		Map<String, Object> properties = new HashMap<>();
		properties.put("builder", Builder.GIBSON);
		properties.put("backWood", Wood.MAPLE);

		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		List<? extends Instrument> machedGuitars = inventory.search(clientSpec);
		showInstruments(machedGuitars);
	}

	private static void showInstruments(List<? extends Instrument> machedGuitars) {
		if (!machedGuitars.isEmpty()) {
			System.out.println("You might like these instruments: ");
			machedGuitars.forEach(g -> {
				System.out.println("We have a " +
						g.getSpec().getProperty("instrumentType") + " with the fofollowing properties:");
				for (String propName : g.getSpec().getProperties().keySet()) {
					if (!propName.equals("instrumentType")) {
						System.out.println("     " + propName + ": " + g.getSpec().getProperty(propName));
					}
				}
				System.out.println("   " + "You can have this " + g.getSpec().getProperty("instrumentType") + " for $" + g.getPrice() + "\n----");
			});
			// System.out.println(machedGuitars);
		} else {
			System.out.println("Sorry, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.COLLINGS);
		properties.put("model", "CJ");
		properties.put("type", Type.ACOUSTIC);
		properties.put("numStrings", 6);
		properties.put("backWood", Wood.INDIAN_ROSEWOOD);
		properties.put("topkWood", Wood.SITKA);
		InstrumentSpec instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("11277", 3999.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.MARTIN);
		properties.put("model", "D-18");
		properties.put("type", Type.ACOUSTIC);
		properties.put("numStrings", 6);
		properties.put("backWood", Wood.MAHOGANY);
		properties.put("topkWood", Wood.ADIRONDACK);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("122784", 5495.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("numStrings", 6);
		properties.put("backWood", Wood.ALDER);
		properties.put("topkWood", Wood.SITKA);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("95693", 1499.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("numStrings", 6);
		properties.put("backWood", Wood.ALDER);
		properties.put("topkWood", Wood.SITKA);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("9512", 1549.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.GIBSON);
		properties.put("model", "SG `61 Reissue");
		properties.put("type", Type.ELECTRIC);
		properties.put("numStrings", 6);
		properties.put("backWood", Wood.MAHOGANY);
		properties.put("topkWood", Wood.MAHOGANY);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("82765501", 1890.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.GIBSON);
		properties.put("model", "Less Paul");
		properties.put("type", Type.ELECTRIC);
		properties.put("numStrings", 6);
		properties.put("backWood", Wood.MAPLE);
		properties.put("topkWood", Wood.MAPLE);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("70108276", 2295.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.MANDOLIN);
		properties.put("builder", Builder.GIBSON);
		properties.put("model", "F5-G");
		properties.put("type", Type.ACOUSTIC);
		properties.put("backWood", Wood.MAPLE);
		properties.put("topkWood", Wood.MAPLE);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("9019920", 5495.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.BANJO);
		properties.put("builder", Builder.GIBSON);
		properties.put("model", "RB-3");
		properties.put("numStrings", 5);
		properties.put("type", Type.ACOUSTIC);
		properties.put("backWood", Wood.MAPLE);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument("8900231", 2945.95, instrumentSpec);
	}

}
