package com.farhad.example.design_principles02.test_design.domain.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
		assertThat(account.getBalance()).isEqualTo(100d);
	}

	@Test
	void addingTransactionToAccountDelegatesToAccountInstanceWithMockito() {
		//given
		Account account = new Account();
		AccountRepository accountRepository = mock(AccountRepository.class);
		Mockito.when(accountRepository.getByName(any())).thenReturn(account);
		AccountService accountService = new AccountServiceImpl(accountRepository);
		//when
		accountService.addTransactionToAccount("Training Account", 100d);
		//then
		assertThat(account.getBalance()).isEqualTo(100d);
	}
	@Test
	void t() {
		//given
		//when
		//then
	}

}
