package com.farhad.example.design_principles02.test_design.domain.application;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.farhad.example.design_principles02.test_design.domain.adapter.persistence.FakeAccountRepository;
import com.farhad.example.design_principles02.test_design.domain.application.impl.AccountServiceImpl;
import com.farhad.example.design_principles02.test_design.domain.model.Account;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;

public class AccountServiceTest {

	@Test
	void addingTransactionToAccountDelegatesToAccountInstance() {
		//given
		Account account = new Account();
		AccountRepository accountRepository = new FakeAccountRepository(account);
		AccountService accountService = new AccountServiceImpl(accountRepository);
		//when
		accountService.addTransactionToAccount("Training Account", 100d);
		//then
		fail();
	}

	@Test
	void t() {
		//given
		//when
		//then
	}

}
