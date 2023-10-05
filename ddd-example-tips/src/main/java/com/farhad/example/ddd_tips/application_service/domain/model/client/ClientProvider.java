package com.farhad.example.ddd_tips.application_service.domain.model.client;

import java.util.Optional;

import lombok.NonNull;

public interface ClientProvider {

    Optional<Client> fetchClient(@NonNull String clientId);
    
}
