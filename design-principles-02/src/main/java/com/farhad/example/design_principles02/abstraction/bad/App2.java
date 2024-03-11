package com.farhad.example.design_principles02.abstraction.bad;

public class App2 {

	public static void main(String[] args) {
		
		AtmMachine am = new AtmMachine();

		am.enterCard();
		am.enterPin();
		am.cash_withdrawal();
		am.cashDispose();
	}
}
