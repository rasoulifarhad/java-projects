package com.farhad.example.design_principles02.sales_invoice.awt_test;

import java.awt.FlowLayout;
import java.awt.Frame;
public class LTextFieldUser extends  Frame {

	public LTextFieldUser() {
		init();
	}

	public void init() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new LTextField("Name: ", 40, 15));
		add(new LTextField("Address: ", 40, 15));
		add(new LTextField("City, State, Zip: ", 15, 15));
		add(new LTextField("", 2, 0));
		add(new LTextField("", 10, 0));
		setSize(600, 600);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		LTextFieldUser lTextFieldUser = new LTextFieldUser();
	}
}
