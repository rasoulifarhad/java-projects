package com.farhad.example.design_principles02.grasp.creator;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<OrderItem> items;

	public Order() {
		items = new ArrayList<>();
	}

	public void addItem(Product product, int quantity) {
		items.add(new OrderItem(product, quantity));
	}

	
}
