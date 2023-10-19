package com.farhad.example.design_principles02.test_design.domain.adapter.persistence;

import com.farhad.example.design_principles02.test_design.domain.model.AccountBase;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FakeAccountRepository implements AccountRepository {
	
	private AccountBase account;

	@Override
	public AccountBase getByName(String accountName) {
		return account;
	}

	@Override
	public AccountBase newAccount(AccountBase account) {
		this.account = account;
		return this.account;
	}
}
