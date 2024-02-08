package com.farhad.example.design_principles02.shop_demo;

public class App {

	public static void main(String[] args) {
		
		Shop shop = null;
		String clazzName = "com.farhad.example.design_principles02.shop_demo.DonutShop";
		System.out.println("\nInstantiate the class: " + clazzName + "\n");

		try {
			shop = (Shop)Class.forName(clazzName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		String[] inventory = shop.getInventory();
		for (int i = 0; i < inventory.length; i++) {
			System.out.println("Argument" + i + " = " + inventory[i]);
		}

		shop.buyInventory(inventory[1]);
 	}
}
