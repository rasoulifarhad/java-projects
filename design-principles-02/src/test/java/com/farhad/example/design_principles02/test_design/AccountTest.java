package com.farhad.example.design_principles02.test_design;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

	@Test
	void addingTransactionChangesBalance() {
		//given
		Account account = new Account();
		//when
		account.addTransaction(200d);
		//then
		Assertions.assertThat(account.getBalance()).isEqualTo(200d);
	}
}


