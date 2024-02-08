package com.farhad.example.design_principles02.shop_demo;

public class DonutShop extends Shop implements Nameable {

	private String companyName;

	String [] menuItems = {
			"Donuts",
			"Muffins",
			"Danish",
			"Coffee",
			"Tea"
	};
	@Override
	public String getName() {
		return companyName;
	}

	@Override

	public void setName(String name) {
		this.companyName = name;
	}

	@Override
	public String[] getInventory() {
		return menuItems;
	}

	@Override
	public void buyInventory(String item) {
		System.out.println("\nYou have just purchased " + item);
	}

}
