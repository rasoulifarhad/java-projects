package com.farhad.example.factory_beverage_machine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

	private String name;
	private double price;
	private int inventory;

	public void addInventory(int qty) {
		inventory += qty;
	}

	public void subtractInventory(int qty) {
		inventory -= qty;
	}
}

