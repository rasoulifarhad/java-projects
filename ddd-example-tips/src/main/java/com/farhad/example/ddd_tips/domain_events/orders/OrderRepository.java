package com.farhad.example.ddd_tips.domain_events.orders;

public interface OrderRepository {

    Order find(OrderId order);
    
}
