package com.farhad.example.ddd_tips.domain_events.orders;

import java.time.Instant;
import java.util.Objects;

import lombok.Data;

@Data
public class OrderShipped implements DomainEvent {
    private final OrderId order;
    private final Instant occuredOn;

    public OrderShipped(OrderId order, Instant occuredOn) {
        this.order = Objects.requireNonNull(order);
        this.occuredOn = Objects.requireNonNull(occuredOn);
    }

    
}
