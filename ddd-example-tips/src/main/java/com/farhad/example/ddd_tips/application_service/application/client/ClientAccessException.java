package com.farhad.example.ddd_tips.application_service.application.client;

public class ClientAccessException extends RuntimeException {
    
    public ClientAccessException(String message){
        super(message);
    }
}
