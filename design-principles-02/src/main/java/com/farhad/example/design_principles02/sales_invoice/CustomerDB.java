package com.farhad.example.design_principles02.sales_invoice;

import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

	private static final int MAX = 100;
	private static Customer[] customers = new Customer[MAX];

	private static int lastCustomer = 0;

	private static List<String> uiList = new ArrayList<>();

	static {
		customers[0] = new Customer("Customer", "Cash", new Address("", "", "WA", "", ""), 0.0, 0.0);
	}

	public static Customer getCustomer(int customerNumber) {
		if (customerNumber >= lastCustomer) {
			customerNumber = 0;
		}
		return customers[customerNumber];
	}

	public static int addToDatabase(Customer customer) {
		int id = generateId();
		customers[id] = customer;
		uiList.add(customer.getFullName());
		return id;
	}

	public static List<String> pickList() {
		return uiList;
	}
	private static int generateId() {
		return lastCustomer++;
	}
}
