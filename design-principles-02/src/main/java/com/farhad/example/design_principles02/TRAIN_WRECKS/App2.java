package com.farhad.example.design_principles02.TRAIN_WRECKS;

public class App2 {
	

	public static void main(String[] args) {
		Customer customer = new Customer();

		double aount = customer.orders.last().totals().amount;
	}
}
