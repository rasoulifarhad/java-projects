package com.farhad.example.OOADP_Lab.strategy;

public class StrategyDemo {

	public static void main(String[] args) {
		
		Customer customer = new RCCustomer("rc1", "rc1 customer");
		customer.printBill(100);

		customer = new SCCustomer("sc1", "sc1 customer");
		customer.printBill(100);

		customer = new FTCCustomer("ftc1", "ftc1 customer");
		customer.printBill(100);
	}
}
