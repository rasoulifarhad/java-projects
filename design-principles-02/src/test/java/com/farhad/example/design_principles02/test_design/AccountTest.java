package com.farhad.example.design_principles02.test_design;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AccountTest {

	@Test
	void addingTransactionChangesBalance() {
		//given
		Account account = new Account();
		//when
		account.addTransaction(200d);
		//then
		assertThat(account.getBalance()).isEqualTo(200d);
	}

	@Test
	void accountsHaveAnOpeningBalanceOfZero() {
		//given

		//when
		Account account = new Account();
		//then
		assertThat(account.getBalance()).isEqualTo(0d);
	}

	@Test
	void adding100TransactionChangesBalance() {
		//given
		Account account = new Account();
		//when
		account.addTransaction(100d);
		//then
		assertThat(account.getBalance()).isEqualTo(100d);
	}


	@Test
	void addingTwoTransactionsCreatesSummationBalance() {
		//given
		Account account = new Account();
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


