package com.farhad.example.design_principles02.abstraction.bad;

// You might have used ATM machines many times for cash withdrawal and bank statements. The ATM Machine has 
// given a card swipe slot, a touch screen, and a keyboard, you can use these features to withdraw the money 
// but you never know what exact actions or operations takes place internally in the machine-like after a card 
// swipe the machine checks whether the card is valid or not, then the PIN will be verified if it is correct 
// then only we can withdraw the money but the withdraw money should not be greater than the available balance.
//
// - Cash Withdrawal
// - Money transfer 
// - Mini statement
//
public class App {

	public static void main(String[] args) {
		
		AtmMachine am = new AtmMachine();

		am.enterCard();
		am.enterPin();
		am.cash_withdrawal();
		am.validate_withdraw_amount();
		am.updateAmount();
		am.cashDispose();
	}

}
