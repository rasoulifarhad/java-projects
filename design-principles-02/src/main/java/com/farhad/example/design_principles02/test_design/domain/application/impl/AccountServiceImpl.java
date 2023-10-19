package com.farhad.example.design_principles02.test_design.domain.application.impl;

import com.farhad.example.design_principles02.test_design.domain.application.AccountService;
import com.farhad.example.design_principles02.test_design.domain.application.BusinessException;
import com.farhad.example.design_principles02.test_design.domain.model.AccountBase;
import com.farhad.example.design_principles02.test_design.domain.model.AccountFactory;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;
import com.farhad.example.design_principles02.test_design.domain.model.AccountType;
import com.farhad.example.design_principles02.test_design.domain.model.DomainException;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

	@NonNull
	private final AccountRepository accountRepository;

	@NonNull
	private final AccountFactory accountFactory;

	@Override
	public void addTransactionToAccount(String accountName, double amount) {
		try {
			AccountBase account = accountRepository.getByName(accountName);
			if(account != null) {
				account.addTransaction(amount);
			}
		} catch (DomainException  e) {
			throw new BusinessException("adding transaction to account failed", e);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}

	@Override
	public AccountBase createAccount(AccountType type) {
		// AccountBase account = AccountBase.createAccount(type);
		AccountBase account = accountFactory.createAccount(type);
		return accountRepository.newAccount(account);
	}
}
