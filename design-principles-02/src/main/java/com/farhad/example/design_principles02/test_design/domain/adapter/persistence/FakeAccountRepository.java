package com.farhad.example.design_principles02.test_design.domain.adapter.persistence;

import com.farhad.example.design_principles02.test_design.domain.model.Account;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FakeAccountRepository implements AccountRepository {
	
	private final Account account;

	@Override
	public Account getByName(String accountName) {
		return account;
	}
}
