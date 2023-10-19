package com.farhad.example.design_principles02.test_design;

public class Account {

	private double balance;
	public void addTransaction(double amount) {
		balance += amount;
	}

	public double getBalance() {
		return balance;
	}
	
}
