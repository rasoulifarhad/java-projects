package com.farhad.example.design_principles02.grasp.creator;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

	List<InvoiceItem> items;

	public Invoice() {
		items = new ArrayList<>();
	}

	public void addItem(String name, int price) {
		items.add(new InvoiceItem(name, price));
	}

	
}
