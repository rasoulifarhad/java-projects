package com.farhad.example.ddd_tips.application_service.domain.model.client;

import java.util.Optional;

import lombok.NonNull;

public class ClientProviderStub implements ClientProvider{

    @Override
    public Optional<Client> fetchClient(@NonNull String name) {
        switch (name) {
            case "client1":
                return Optional.of(new Client(name, false));
            case "client2":
                return Optional.of(new Client(name, true));
        
            default:
                return Optional.empty();
        }
    }
    
}
