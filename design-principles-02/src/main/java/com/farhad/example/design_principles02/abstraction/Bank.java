package com.farhad.example.design_principles02.abstraction;

public abstract class Bank {

	abstract int getRateOfInterest();

	public static void main(String[] args) {
		
		Bank bank;
		bank = new SBI();
		System.out.println("SBI rate of intrest is: " + bank.getRateOfInterest());
		bank = new PNB();
		System.out.println("PNB rate of intrest is: " + bank.getRateOfInterest());
	}
}
