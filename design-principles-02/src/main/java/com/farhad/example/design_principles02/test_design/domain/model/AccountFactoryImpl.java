package com.farhad.example.design_principles02.test_design.domain.model;

public class AccountFactoryImpl implements AccountFactory {

	@Override
	public AccountBase createAccount(AccountType type) {
		
		AccountBase account = null;

		switch (type) {
			case Silver:
				account = new SilverAccount();
				break;
			case Gold:
				account = new GoldAccount();
				break;
			case Platinum:
				account = new PlatinumAccount();
				break;
			default:
				break;
		}
		return account;
	}
	
}
