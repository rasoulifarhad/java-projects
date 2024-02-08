package com.farhad.example.design_principles02.shop_demo;

public class PizzaShop extends Shop implements Nameable {

	private String companyName;

	String[] foodOfferings = {
			"Pizza",
			"Spaghetti",
			"Garden Salad", "Anitpasto", "Calzone"
	};

	@Override
	public String getName() {
		return companyName;
	}

	@Override
	public void setName(String name) {
		companyName = name;
	}

	@Override
	public String[] getInventory() {
		return foodOfferings;
	}

	@Override
	public void buyInventory(String item) {
		System.out.println("\nYou have just purchased "+ item);
	}

}
