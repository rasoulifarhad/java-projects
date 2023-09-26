package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core;

import java.time.Instant;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
public class Order {
    private OrderId id;
    private Instant date;


    @Value
    @AllArgsConstructor
    public static class OrderId {
        @NotNull
        private final UUID uuid;

    }
}
