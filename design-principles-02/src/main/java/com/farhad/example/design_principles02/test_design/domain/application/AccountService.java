package com.farhad.example.design_principles02.test_design.domain.application;

import com.farhad.example.design_principles02.test_design.domain.model.AccountBase;
import com.farhad.example.design_principles02.test_design.domain.model.AccountType;

public interface AccountService {

	AccountBase createAccount(AccountType type);
	void addTransactionToAccount(String accountName, double amount);
	
}
