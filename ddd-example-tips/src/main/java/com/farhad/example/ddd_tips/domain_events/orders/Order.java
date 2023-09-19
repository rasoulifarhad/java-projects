package com.farhad.example.ddd_tips.domain_events.orders;

import java.time.Instant;

public class Order extends AggregateRoot<OrderId> {

    public Order(OrderId id) {
        super(id);
    }

    public void ship() {
        registerEvent(new OrderShipped(this.getId(), Instant.now()));
    }

    private void registerEvent(OrderShipped orderShipped) {
    }
    
}
