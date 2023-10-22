package com.farhad.example.design_principles02.value_object;

import lombok.Getter;

public class Transaction {
	
	@Getter
	private int value;

	public Transaction(int value, Account credit, Account debit) {
		this.value = value;
		credit.addCredit(this);
		debit.addDebit(this);
	}

	
}
