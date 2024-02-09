package com.farhad.example.design_principles02.rock_and_roll.third;

import java.util.List;

public class FindGuitarTester {
	
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		GuitarSpec whatBuyerLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER,
				Wood.ALDER);
		List<Guitar> machedGuitars = inventory.search(whatBuyerLikes);

		if (!machedGuitars.isEmpty()) {
			System.out.println("Buyer, you might like these guitars: ");
			machedGuitars.forEach(g -> {
				System.out.println("  We have a " +
						g.getGuitarSpec().getBuilder() + " " +
						g.getGuitarSpec().getModel() + " " +
						g.getGuitarSpec().getType() + " guitar:");
				System.out.println("     " + g.getGuitarSpec().getBackWood() + " back and side,");
				System.out.println("     " + g.getGuitarSpec().getTopWood() + " top.");
				System.out.println("  " + "You can have it for only $" + g.getPrice() + "!");
				System.out.println("-----");
			});
			// System.out.println(machedGuitars);
		} else {
			System.out.println("Sorry, Buyer, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("V1234", 1234.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("V6789", 1321.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	}

}
