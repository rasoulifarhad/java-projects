package com.farhad.example.design_principles02.abstraction.better;

public class AtmMachine {

	public void enterCard() {
		System.out.println("card verification");
	}

	public void enterPin() {
		System.out.println("pin verification");
	}

	public void cash_withdrawal() {
		System.out.println("To withdraw cash from ATM");
		validate_withdraw_amount();
		updateAmount();
		cashDispose();
	}

	private void validate_withdraw_amount() {
		System.out.println("   Validate the amount to be withdraw");
	}

	private void updateAmount() {
		System.out.println("   Update the Amount after withdraw");
	}

	private void cashDispose() {
		System.out.println("   Disponse the cash from ATM");
	}

	public void miniStatement() {
		System.out.println("Get the mini statement");
	}
}
