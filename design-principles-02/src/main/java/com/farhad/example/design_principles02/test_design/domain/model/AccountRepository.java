package com.farhad.example.design_principles02.test_design.domain.model;

public interface AccountRepository {
	AccountBase getByName(String accountName);

	AccountBase newAccount(AccountBase account);
}
