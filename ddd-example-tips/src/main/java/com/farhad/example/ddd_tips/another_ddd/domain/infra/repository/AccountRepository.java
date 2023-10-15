package com.farhad.example.ddd_tips.another_ddd.domain.infra.repository;

import com.farhad.example.ddd_tips.another_ddd.domain.model.account.Account;

public interface AccountRepository {
	Account findAccountById(String accountNumber);
}
