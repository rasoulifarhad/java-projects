package com.farhad.example.design_principles02.abstraction.bad;

public class AtmMachine {

	public void enterCard() {
		System.out.println("card verification");
	}

	public void enterPin() {
		System.out.println("pin verification");
	}

	public void cash_withdrawal() {
		System.out.println("To withdraw cash from ATM");
	}

	public void validate_withdraw_amount() {
		System.out.println("Validate the amount to be withdraw");
	}

	public void updateAmount() {
		System.out.println("Update the Amount after withdraw");
	}

	public void cashDispose() {
		System.out.println("Disponse the cash from ATM");
	}

	public void miniStatement() {
		System.out.println("Get the mini statement");
	}
}
