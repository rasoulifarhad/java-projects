package com.farhad.example.ddd_tips.application_service.domain.model.client;

public class ClientAccessException extends RuntimeException {
    
    public ClientAccessException(String message){
        super(message);
    }
}
