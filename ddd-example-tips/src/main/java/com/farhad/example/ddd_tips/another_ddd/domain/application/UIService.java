package com.farhad.example.ddd_tips.another_ddd.domain.application;

import com.farhad.example.ddd_tips.another_ddd.domain.infra.repository.ClientRepository;
import com.farhad.example.ddd_tips.another_ddd.domain.model.client.Client;
public class UIService {
	
	ClientRepository clientRepository;
	String getClinetCity(String clientNumber) {
		Client client = clientRepository.findById(clientNumber);
		return client.city();

	}	
}
