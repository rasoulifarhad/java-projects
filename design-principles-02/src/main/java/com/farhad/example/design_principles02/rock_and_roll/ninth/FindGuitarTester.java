package com.farhad.example.design_principles02.rock_and_roll.ninth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.Instrument;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.InstrumentSpec;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.InstrumentType;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.share.Style;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.ninth.instrument.share.Wood;

public class FindGuitarTester {
	
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		Map<String, Object> properties = new HashMap<>();
		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("numStrings", "");
		properties.put("backWood", Wood.ALDER);
		properties.put("topkWood", Wood.ALDER);
		InstrumentSpec whatBuyerLikes = new InstrumentSpec(properties);
		List<? extends Instrument> machedGuitars = inventory.search(whatBuyerLikes);

		if (!machedGuitars.isEmpty()) {
			System.out.println("Buyer, you might like these guitars: ");
			machedGuitars.forEach(g -> {
				System.out.println("  We have a " +
						g.getSpec().getProperty("builder") + " " +
						g.getSpec().getProperty("model") + " " +
						g.getSpec().getProperty("type") + " guitar:");
				System.out.println("     " + g.getSpec().getProperty("backWood") + " back and side,");
				System.out.println("     " + g.getSpec().getProperty("topWood") + " top.");
				System.out.println("  " + "You can have it for only $" + g.getPrice() + "!");
				System.out.println("-----");
			});
			// System.out.println(machedGuitars);
		} else {
			System.out.println("Sorry, Buyer, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("numStrings", "");
		properties.put("backWood", Wood.ALDER);
		properties.put("topkWood", Wood.ALDER);

		InstrumentSpec instrumentSpec = new InstrumentSpec(properties);

		inventory.addInstrument(InstrumentType.GUITAR, "V1234", 1234.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("numStrings", "");
		properties.put("backWood", Wood.ALDER);
		properties.put("topkWood", Wood.ALDER);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument(InstrumentType.GUITAR, "V6789", 1321.95, instrumentSpec);


		properties = new HashMap<>();
		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("style", Style.A);
		properties.put("backWood", Wood.ALDER);
		properties.put("topkWood", Wood.ALDER);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument(InstrumentType.MANDOLIN, "V1234", 1234.95, instrumentSpec);

		properties = new HashMap<>();
		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("style", Style.F);
		properties.put("backWood", Wood.ALDER);
		properties.put("topkWood", Wood.ALDER);
		instrumentSpec = new InstrumentSpec(properties);
		inventory.addInstrument(InstrumentType.MANDOLIN, "V6789", 1321.95, instrumentSpec);

	}

}
