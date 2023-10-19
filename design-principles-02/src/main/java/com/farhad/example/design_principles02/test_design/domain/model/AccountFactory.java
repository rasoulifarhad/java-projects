package com.farhad.example.design_principles02.test_design.domain.model;

public interface AccountFactory {
	AccountBase createAccount(AccountType type);
}
