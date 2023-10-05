package com.farhad.example.ddd_tips.application_service.domain.model.order;

import java.util.List;
import java.util.Optional;

import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import lombok.NonNull;

public class Order {

    public enum Status {
        PLACED
    }
    
    private Status status;

    public void add(@NonNull List<Product> products) {
    }

    public static Order init(@NonNull String clientId) {
        return null;
    }

    public Optional<Order> place(Client client, OrderAccessPolicy orderAccessPolicy) {
        return null;
    }

    public Order reject() {
        return null;
    }

    public String getId() {
        return null;
    }
    
}
