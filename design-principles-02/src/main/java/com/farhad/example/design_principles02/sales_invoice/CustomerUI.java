package com.farhad.example.design_principles02.sales_invoice;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CustomerUI extends Panel implements ActionListener {

	private Customer customer;
	private String text;

	public CustomerUI(Customer customer, String text) {
		this.customer = customer;
		this.text = text;
		initUI();
	}

	public void initUI() {

		setLayout(new FlowLayout());
		// setBackground(Color.GREEN);
		pickCustomerBtn = new Button("Select" + text);
		newCustomerBtn = new Button("New" + text);

		add(pickCustomerBtn);
		add(newCustomerBtn);
		pickCustomerBtn.addActionListener(this);
		newCustomerBtn.addActionListener(this);

		add(new TextField(customer.getFullName()));
		
	}
	public void addNewCustomer() {

	}

	public Customer getCustomer() {
		return customer;
	}


	private Button pickCustomerBtn = new Button("Select" + text);
	private Button newCustomerBtn = new Button("New" + text);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}

}
