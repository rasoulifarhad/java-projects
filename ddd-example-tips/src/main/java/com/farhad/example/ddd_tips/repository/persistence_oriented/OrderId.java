package com.farhad.example.ddd_tips.repository.persistence_oriented;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class OrderId {
    public static OrderId createRandomUnique() {
        return new OrderId(UUID.randomUUID().toString());
    }

    private final String id;
}

