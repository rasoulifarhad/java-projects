package com.farhad.example.ddd_tips.application_service.domain.model.client;

import lombok.Getter;

@Getter
public class Client {

    private String name;
    
    private boolean hasPremiumSubscription;

    public Client(String name, boolean hasPremiumSubscription) {
        this.name = name;
        this.hasPremiumSubscription = hasPremiumSubscription;
    }
    
}
