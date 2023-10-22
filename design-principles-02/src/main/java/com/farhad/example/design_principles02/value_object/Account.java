package com.farhad.example.design_principles02.value_object;

import java.util.ArrayList;
import java.util.List;

public class Account {

	List<Transaction>  creditList = new ArrayList<>();
	List<Transaction>  debitList = new ArrayList<>();
	public void addCredit(Transaction transaction) {
		creditList.add(transaction);
	}

	public void addDebit(Transaction transaction) {
		debitList.add(transaction);
	}

}
