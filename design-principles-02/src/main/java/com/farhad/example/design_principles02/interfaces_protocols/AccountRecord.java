package com.farhad.example.design_principles02.interfaces_protocols;

public class AccountRecord {

	// # wraps an account with the ability
    // # to be fetched and stored
	Account account;


	void save() {
		// save account
	}

	Account load() {
		// load account
		return null;
	}
}
