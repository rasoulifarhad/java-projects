package com.farhad.example.ddd_tips.another_ddd.domain.model.security;

import com.farhad.example.ddd_tips.another_ddd.domain.model.client.Client;

public interface RoleSet {
	boolean IsPrintClientDetailsPermitted(Client client);
}
