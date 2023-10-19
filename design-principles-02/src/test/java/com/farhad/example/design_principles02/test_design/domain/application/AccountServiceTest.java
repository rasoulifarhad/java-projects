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

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.design_principles02.test_design.domain.adapter.persistence.FakeAccountRepository;
import com.farhad.example.design_principles02.test_design.domain.application.impl.AccountServiceImpl;
import com.farhad.example.design_principles02.test_design.domain.model.AccountBase;
import com.farhad.example.design_principles02.test_design.domain.model.AccountFactory;
import com.farhad.example.design_principles02.test_design.domain.model.AccountFactoryImpl;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;
import com.farhad.example.design_principles02.test_design.domain.model.DomainException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class AccountServiceTest {
	

	private AccountServiceBuilder accountServiceBuilder;
	private AccountFactory accountFactory;
	  

	@BeforeEach
	public void setup() {
		accountServiceBuilder = AccountServiceBuilder.of();
		accountFactory = new AccountFactoryImpl();
	}

	@Test
	void addingTransactionToAccountDelegatesToAccountInstance() {
		//given
		AccountBase account = AccountBase.silver();
		AccountRepository mockAccountRepository = new FakeAccountRepository(account);
		AccountService accountService = new AccountServiceImpl(mockAccountRepository, accountFactory);
		//when
		accountService.addTransactionToAccount("Trading Account", 100d);
		//then
		assertThat(account.getBalance()).isEqualTo(100d);
	}

	@Test
	void addingTransactionToAccountDelegatesToAccountInstanceWithMockito() {
		//given

		AccountService accountService = 
							accountServiceBuilder
									.withAccountCalled("Trading Account")
									.build();
		//when
		accountService.addTransactionToAccount("Trading Account", 100d);
		//then
		verify(accountServiceBuilder.account,times(1)).addTransaction(100d);
	}

	@Test
	void canNotCreateAccountServiceWithNullAccountRepository() {
		//given
		//when
		//then
		assertThrows(NullPointerException.class, () ->new AccountServiceImpl(null, null) );
	}

	@Test
	void doNotThrownWhenAccountNotFound() {
		//given
		AccountService accountService = accountServiceBuilder.build();
		//when
		accountService.addTransactionToAccount("Trading Account",	100d);
		//then
	}

	@Test
	void accountRepositoryExceptionsAreWrappedInThrowBusinessServiceException() {
		//given
		AccountService accountService = 
			accountServiceBuilder
				.withRepositoryConsumer(accountRepository -> 
					when(accountRepository.getByName("Trading Account"))
						.thenThrow(
							new DomainException(new RuntimeException("Error"))))
				.build();
		//when
		//then
		BusinessException businessException = assertThrows(BusinessException.class, 
								() -> accountService.addTransactionToAccount("Trading Account", 100d));
		assertTrue(businessException.getCause() instanceof DomainException);
	}

	@Test
	void accountExceptionsAreWrappedInThrowBusinessServiceException() {
		//given
		AccountService accountService = 
			accountServiceBuilder
				.withAccountCalled("Trading Account")
				.withAccountConsumer(account -> 
					doThrow(new DomainException("Error in addTransaction."))
						.when(account).addTransaction(100d))
				.build();

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
		private AccountFactory accountFactory;

		@Getter
		@Setter(value = AccessLevel.PRIVATE)
		private AccountBase account;

		private AccountServiceBuilder() {
			accountRepository = mock(AccountRepository.class);
			accountFactory = new AccountFactoryImpl();
			accountService = new AccountServiceImpl(accountRepository, accountFactory);
		}

		public static AccountServiceBuilder of() {
			return new AccountServiceBuilder();
		}
		public AccountServiceBuilder withAccountCalled(String accountName) {
			account = mock(AccountBase.class);
			when(accountRepository.getByName(accountName)).thenReturn(account);
			return this;
		}

		public AccountServiceBuilder withRepositoryConsumer(Consumer<AccountRepository> consume) {
			consume.accept(accountRepository);
			return this;
		}

		public AccountServiceBuilder withAccountConsumer(Consumer<AccountBase> consume) {
			consume.accept(account);
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
