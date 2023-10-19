package com.farhad.example.design_principles02.test_design.domain.application.impl;

import com.farhad.example.design_principles02.test_design.domain.application.AccountService;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepository;

	@Override
	public void addTransactionToAccount(String string, double d) {
	}
}
