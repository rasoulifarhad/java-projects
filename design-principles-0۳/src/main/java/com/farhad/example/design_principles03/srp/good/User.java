package com.farhad.example.design_principles03.srp.good;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {
    
    private final String firstName;
    private final String lastName;
    private final String email;
    private final SubscriptionType subscriptionType;
    private final Date subscriptionExpirationDate;

    public String getName() {
        return firstName + " " + lastName;
    }

    public enum SubscriptionType {
        STANDARD, VIP
    }
}
