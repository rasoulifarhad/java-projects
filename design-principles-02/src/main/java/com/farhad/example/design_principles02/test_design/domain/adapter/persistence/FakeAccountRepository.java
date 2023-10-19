package com.farhad.example.design_principles02.test_design.domain.adapter.persistence;

import com.farhad.example.design_principles02.test_design.domain.model.AccountBase;
import com.farhad.example.design_principles02.test_design.domain.model.AccountRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FakeAccountRepository implements AccountRepository {
	
	private final AccountBase account;

	@Override
	public AccountBase getByName(String accountName) {
		return account;
	}
}
