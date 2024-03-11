package com.farhad.example.design_principles02.abstraction.better;

//
// By using the abstraction principle. The methods which you want to expose, make them 
// public and the methods which you don’t want to expose, make them private.
public class App {

	public static void main(String[] args) {
		
		AtmMachine am = new AtmMachine();

		am.enterCard();
		am.enterPin();
		am.cash_withdrawal();
	}

}
