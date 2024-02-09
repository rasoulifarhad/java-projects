package com.farhad.example.design_principles02.rock_and_roll.second;

public class FindGuitarTester {
	
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		Guitar whatBuyerLikes = new Guitar("", 0, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER,
				Wood.ALDER);
		Guitar guitar = inventory.search(whatBuyerLikes);

		if (guitar != null) {
			System.out.println("Buyer, you might like this: ");
			System.out.println(guitar.toString());
		} else {
			System.out.println("Sorry, Buyer, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("123456", 12.0, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	}

}
