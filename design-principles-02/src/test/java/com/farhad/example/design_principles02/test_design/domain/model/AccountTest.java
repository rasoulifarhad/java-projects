package com.farhad.example.design_principles02.test_design.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AccountTest {

	@Test
	void addingTransactionChangesBalance() {
		//given
		AccountBase account = AccountBase.silver();
		//when
		account.addTransaction(200d);
		//then
		assertThat(account.getBalance()).isEqualTo(200d);
	}

	@Test
	void accountsHaveAnOpeningBalanceOfZero() {
		//given

		//when
		AccountBase account = AccountBase.silver();
		//then
		assertThat(account.getBalance()).isEqualTo(0d);
	}

	@Test
	void adding100TransactionChangesBalance() {
		//given
		AccountBase account = AccountBase.silver();
		//when
		account.addTransaction(100d);
		//then
		assertThat(account.getBalance()).isEqualTo(100d);
	}


	@Test
	void addingTwoTransactionsCreatesSummationBalance() {
		//given
		AccountBase account = AccountBase.silver();
		account.addTransaction(50d);
		//when
		account.addTransaction(75d);
		//then
		assertThat(account.getBalance()).isEqualTo(125d);
	}
	
	@Test
	void t() {
		//given
		//when
		//then
	}

}


