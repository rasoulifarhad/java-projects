package com.farhad.example.design_principles02.test_design.domain.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.design_principles02.test_design.domain.adapter.persistence.FakeAccountRepository;
import com.farhad.example.design_principles02.test_design.domain.application.impl.AccountServiceImpl;
import com.farhad.example.design_principles02.test_design.domain.model.Account;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;
import com.farhad.example.design_principles02.test_design.domain.model.DomainException;

public class AccountServiceTest {
	
	private AccountRepository fakeAccountRepository;
	
	private AccountRepository mockAccountRepository;

	// System under Test (SuT)
	private AccountService accountService;

	private Account mockAccount;

	@BeforeEach
	public void setup() {
		mockAccount = mock(Account.class);
		mockAccountRepository = mock(AccountRepository.class);
		accountService = new AccountServiceImpl(mockAccountRepository);
		fakeAccountRepository = new FakeAccountRepository(new Account());
	}

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
		when(accountRepository.getByName(any())).thenReturn(account);
		AccountService accountService = new AccountServiceImpl(accountRepository);
		//when
		accountService.addTransactionToAccount("Training Account", 100d);
		//then
		assertThat(account.getBalance()).isEqualTo(100d);
	}

	@Test
	void canNotCreateAccountServiceWithNullAccountRepository() {
		//given
		//when
		//then
		assertThrows(NullPointerException.class, () ->new AccountServiceImpl(null) );
	}

	@Test
	void doNotThrownWhenAccountNotFound() {
		//given
		AccountRepository accountRepository = mock(AccountRepository.class);
		AccountService accountService = new AccountServiceImpl(accountRepository);
		//when
		accountService.addTransactionToAccount("Training Account",	100d);
		//then
	}

	@Test
	void accountExceptionsAreWrappedInThrowBusinessServiceException() {
		//given
		when(mockAccountRepository.getByName(any())).thenThrow(new DomainException(new RuntimeException("Error")));
		//when
		//then
		BusinessException businessException = assertThrows(BusinessException.class, 
								() -> accountService.addTransactionToAccount("Training Account", 100d));
		assertTrue(businessException.getCause() instanceof DomainException);
	}

	@Test
	void t() {
		//given
		//when
		//then
	}

}
