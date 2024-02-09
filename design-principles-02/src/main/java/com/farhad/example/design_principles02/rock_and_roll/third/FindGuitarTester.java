package com.farhad.example.design_principles02.rock_and_roll.third;

import java.util.List;

public class FindGuitarTester {
	
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		GuitarSpec whatBuyerLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER,
				Wood.ALDER);
		List<Guitar> machedGuitar = inventory.search(whatBuyerLikes);

		if (!machedGuitar.isEmpty()) {
			System.out.println("Buyer, you might like these guitars: ");
			System.out.println(machedGuitar);
		} else {
			System.out.println("Sorry, Buyer, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("V1234", 1234.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("V6789", 1321.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	}

}
