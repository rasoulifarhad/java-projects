package com.farhad.example.design_principles02.test_design.domain.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.farhad.example.design_principles02.test_design.domain.adapter.persistence.FakeAccountRepository;
import com.farhad.example.design_principles02.test_design.domain.application.impl.AccountServiceImpl;
import com.farhad.example.design_principles02.test_design.domain.model.Account;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;
import com.farhad.example.design_principles02.test_design.domain.model.DomainException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class AccountServiceTest {
	
	private AccountRepository fakeAccountRepository;
	
	private AccountRepository mockAccountRepository;

	// System under Test (SuT)
	private AccountService accountService;

	private Account mockAccount;

	private AccountServiceBuilder accountServiceBuilder;
	  

	@BeforeEach
	public void setup() {
		mockAccount = mock(Account.class);
		mockAccountRepository = mock(AccountRepository.class);
		accountService = new AccountServiceImpl(mockAccountRepository);
		fakeAccountRepository = new FakeAccountRepository(new Account());
		accountServiceBuilder = AccountServiceBuilder.of();
	}

	@Test
	void addingTransactionToAccountDelegatesToAccountInstance() {
		//given
		Account account = new Account();
		AccountRepository mockAccountRepository = new FakeAccountRepository(account);
		AccountService accountService = new AccountServiceImpl(mockAccountRepository);
		//when
		accountService.addTransactionToAccount("Trading Account", 100d);
		//then
		assertThat(account.getBalance()).isEqualTo(100d);
	}

	@Test
	void addingTransactionToAccountDelegatesToAccountInstanceWithMockito() {
		//given
		Account account = mock(Account.class);
		AccountRepository mockAccountRepository = mock(AccountRepository.class);
		when(mockAccountRepository.getByName("Trading Account")).thenReturn(account);
		AccountService accountService = new AccountServiceImpl(mockAccountRepository);
		//when
		accountService.addTransactionToAccount("Trading Account", 100d);
		//then
		verify(account,times(1)).addTransaction(100d);
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
		AccountRepository mockAccountRepository = mock(AccountRepository.class);
		AccountService accountService = new AccountServiceImpl(mockAccountRepository);
		//when
		accountService.addTransactionToAccount("Trading Account",	100d);
		//then
	}

	@Test
	void accountRepositoryExceptionsAreWrappedInThrowBusinessServiceException() {
		//given
		AccountRepository mockAccountRepository = mock(AccountRepository.class);
		AccountService accountService = new AccountServiceImpl(mockAccountRepository);

		when(mockAccountRepository.getByName("Trading Account")).thenThrow(new DomainException(new RuntimeException("Error")));
		//when
		//then
		BusinessException businessException = assertThrows(BusinessException.class, 
								() -> accountService.addTransactionToAccount("Trading Account", 100d));
		assertTrue(businessException.getCause() instanceof DomainException);
	}

	@Test
	void accountExceptionsAreWrappedInThrowBusinessServiceException() {
		//given
		Account account = Mockito.spy(Account.class);
		AccountRepository mockAccountRepository = mock(AccountRepository.class);
		AccountService accountService = new AccountServiceImpl(mockAccountRepository);

		when(mockAccountRepository.getByName("Trading Account")).thenReturn(account);
		doThrow(new DomainException("Error in addTransaction.")).when(account).addTransaction(100d);
		//when
		//then
		BusinessException businessException = assertThrows(BusinessException.class, 
								() -> accountService.addTransactionToAccount("Trading Account", 100d));
		assertTrue(businessException.getCause() instanceof DomainException);
	}

	@Test
	void addingTransactionToAccountDelegatesToAccountInstanceWithBuilder() {
		//given
		AccountService accountService = accountServiceBuilder
						.withAccountCalled("Trading Account")
						// .addTransactionOfValue(200d)
						.build(); 
		//when
		accountService.addTransactionToAccount("Trading Account", 100d);
		//then
		verify(accountServiceBuilder.account, times(1)).addTransaction(eq(100d));
	}

	@Test
	void t() {
		//given
		//when
		//then
	}

	static class AccountServiceBuilder {
		
		private AccountService accountService;
		private AccountRepository accountRepository;

		@Getter
		@Setter(value = AccessLevel.PRIVATE)
		private Account account;

		private AccountServiceBuilder() {
			accountRepository = mock(AccountRepository.class);
			accountService = new AccountServiceImpl(accountRepository);
		}

		public static AccountServiceBuilder of() {
			return new AccountServiceBuilder();
		}
		public AccountServiceBuilder withAccountCalled(String accountName) {
			account = mock(Account.class);
			when(accountRepository.getByName(accountName)).thenReturn(account);
			return this;
		}

		public AccountServiceBuilder addTransactionOfValue(double amount) {
			account.addTransaction(amount);
			return this;
		}

		public AccountService build() {
			return accountService;
		}
		

	}

}
