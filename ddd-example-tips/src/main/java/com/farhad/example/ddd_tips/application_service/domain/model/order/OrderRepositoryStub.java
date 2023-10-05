package com.farhad.example.ddd_tips.application_service.domain.model.order;

import java.util.UUID;

public class OrderRepositoryStub implements OrderRepository {

    @Override
    public Order save(Order order) {
        return new Order(
            UUID.randomUUID().toString(), 
            order.getProducts(), 
            order.getClientId(), 
            order.getStatus());
    }
    
}
