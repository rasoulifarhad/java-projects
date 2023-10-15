package com.farhad.example.ddd_tips.another_ddd.domain.model;

public interface Bank {
	
	Account createNewAccount(AccountDetail accountDetail);
	Client createNewClient(ClientDetail clientDetail);
    Account getAccount(String accountNumber);
	Client getClient(String clientNumber);
}
