package com.farhad.example.design_principles02.sales_invoice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import lombok.Data;
@Data
public class LineItems {

	private SalesInvoice owner;
	// private List<LineItem> ltems;
	private LineItem[] items;

	private int nItem;

	public LineItems(int size, SalesInvoice owner) {
		this.owner = owner;
		this.nItem = size;
		this.items = new LineItem[size];
		for (int i = 0; i < size; i++) {
			this.items[i] = new LineItem(this);
		}
	}

	public void updateTotals() {
		owner.updateTotals();
	}

	public double getTotal() {
		double total = 0.0;
		for (int i = 0; i < nItem; i++) {
			total += items[i].getTotal();
		}
		return total;
	}

	public void buildUI(Container container) {

		// 1. Create a panel to hold all of the LineItems
		Panel panel1 = new Panel();
		panel1.setLayout(new GridLayout(0, 1, 2, 2));

		// 2. Create a panel to hold the column headers
		Panel panel2 = new Panel();
		panel2.setLayout(new GridLayout(1, 6));

		panel2.add(new Label("Qty.", Label.CENTER));
		panel2.add(new Label("ID.", Label.CENTER));
		panel2.add(new Label("Description", Label.RIGHT));
		panel2.add(new Label("", Label.LEFT));
		panel2.add(new Label("Price", Label.CENTER));
		panel2.add(new Label("Amount", Label.CENTER));
		panel1.add(panel2);

		// 3. Add each of the LineItem objects
		for (int i = 0; i < items.length; i++) {
			Panel p = new Panel();
			p.setLayout(new FlowLayout());
			items[i].buildUI(p);
			panel1.add(p);
		}

		// Add the whole panel to the component
		container.add(panel1);
	}

}
