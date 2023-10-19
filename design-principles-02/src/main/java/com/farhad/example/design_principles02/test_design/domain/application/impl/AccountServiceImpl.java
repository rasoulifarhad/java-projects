package com.farhad.example.design_principles02.test_design.domain.application.impl;

import com.farhad.example.design_principles02.test_design.domain.application.AccountService;
import com.farhad.example.design_principles02.test_design.domain.application.BusinessException;
import com.farhad.example.design_principles02.test_design.domain.model.Account;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

	@NonNull
	private final AccountRepository accountRepository;

	@Override
	public void addTransactionToAccount(String accountName, double amount) {
		try {
			Account account = accountRepository.getByName(accountName);
			if(account != null) {
				account.addTransaction(amount);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
}
