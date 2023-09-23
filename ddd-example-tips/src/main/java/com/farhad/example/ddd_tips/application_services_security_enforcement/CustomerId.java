package com.farhad.example.ddd_tips.application_services_security_enforcement;

import java.util.UUID;

import lombok.Value;

@Value
public class CustomerId {

    private final UUID value;

    public static CustomerId randomId() {
        return new CustomerId(UUID.randomUUID());
    }

    public static CustomerId fromString(String uuidString) {
        return new CustomerId(UUID.fromString(uuidString));
    }

}
