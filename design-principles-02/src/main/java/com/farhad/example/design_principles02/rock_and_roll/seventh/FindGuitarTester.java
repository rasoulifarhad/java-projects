package com.farhad.example.design_principles02.rock_and_roll.seventh;

import java.util.List;

import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.guitar.Guitar;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.guitar.GuitarSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.mandolin.MandolinSpec;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.mandolin.Style;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Builder;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Type;
import com.farhad.example.design_principles02.rock_and_roll.seventh.instrument.share.Wood;

public class FindGuitarTester {
	
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		GuitarSpec whatBuyerLikes = new GuitarSpec( Builder.FENDER, "Stratocastor", Type.ELECTRIC, "", Wood.ALDER,
				Wood.ALDER);
		List<Guitar> machedGuitars = inventory.search(whatBuyerLikes);

		if (!machedGuitars.isEmpty()) {
			System.out.println("Buyer, you might like these guitars: ");
			machedGuitars.forEach(g -> {
				System.out.println("  We have a " +
						g.getSpec().getBuilder() + " " +
						g.getSpec().getModel() + " " +
						g.getSpec().getType() + " guitar:");
				System.out.println("     " + g.getSpec().getBackWood() + " back and side,");
				System.out.println("     " + g.getSpec().getTopWood() + " top.");
				System.out.println("  " + "You can have it for only $" + g.getPrice() + "!");
				System.out.println("-----");
			});
			// System.out.println(machedGuitars);
		} else {
			System.out.println("Sorry, Buyer, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		GuitarSpec guitarSpec = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, "", Wood.ALDER,
				Wood.ALDER);

		inventory.addInstrument("V1234", 1234.95, guitarSpec);

		guitarSpec = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, "", Wood.ALDER, Wood.ALDER);
		inventory.addInstrument("V6789", 1321.95, guitarSpec);


		MandolinSpec mandolinSpec = new MandolinSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Style.A, Wood.ALDER,
				Wood.ALDER);
		inventory.addInstrument("V1234", 1234.95, mandolinSpec);

		mandolinSpec = new MandolinSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Style.F, Wood.ALDER, Wood.ALDER);
		inventory.addInstrument("V6789", 1321.95, mandolinSpec);

	}

}
