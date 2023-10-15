package com.farhad.example.ddd_tips.another_ddd.domain.infra.repository;

import com.farhad.example.ddd_tips.another_ddd.domain.model.client.Client;

public interface ClientRepository {
	Client findById(String clientNumber);
}
