package com.farhad.example.ddd_tips.another_ddd.domain.model;

import com.farhad.example.ddd_tips.another_ddd.domain.model.account.Account;
import com.farhad.example.ddd_tips.another_ddd.domain.model.account.AccountDetail;
import com.farhad.example.ddd_tips.another_ddd.domain.model.client.Client;
import com.farhad.example.ddd_tips.another_ddd.domain.model.client.ClientDetail;

public interface Bank {
	
	Account createNewAccount(AccountDetail accountDetail);
	Client createNewClient(ClientDetail clientDetail);
    Account getAccount(String accountNumber);
	Client getClient(String clientNumber);
}
