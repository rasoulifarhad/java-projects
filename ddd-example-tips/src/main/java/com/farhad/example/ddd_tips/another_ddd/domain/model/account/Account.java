package com.farhad.example.ddd_tips.another_ddd.domain.model.account;

import java.math.BigDecimal;

public interface Account {
	String accountNumber();
	BigDecimal balance();

	public void deposit(BigDecimal amount);

	public BigDecimal withdraw(BigDecimal amount);

	public void moneyTransfer(BigDecimal amount, Account to);

}
