package com.farhad.example.ddd_tips.application_service.application.client;

import java.util.Optional;

import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;

import lombok.NonNull;

public interface ClientProvider {

    Optional<Client> fetchClient(@NonNull String clientId);
    
}
