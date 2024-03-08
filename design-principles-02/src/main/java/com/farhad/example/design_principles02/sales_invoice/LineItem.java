package com.farhad.example.design_principles02.sales_invoice;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import lombok.Data;

@Data
public class LineItem {

	private String itemId;
	private int qty;
	private String description;
	private double price;
	private LineItems lineItems;

	public double getTotal() {
		return price * qty;
	}

	public LineItem(LineItems lineItems) {
		this.lineItems = lineItems;
	}

	public void buildUI(Container c) {
		Panel p2 = new Panel();
		p2.setLayout( new GridLayout( 1, 6 ) );
		p2.add( new TextField(qty ));
		p2.add( new TextField(itemId));
		p2.add( new TextField(description));
		p2.add( new Label( "", Label.LEFT )); // Filler
		p2.add( new TextField(String.valueOf(price)));
		p2.add( new TextField(String.valueOf(getTotal())));
		c.add( p2 );	
	}
}
