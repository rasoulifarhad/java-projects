package com.farhad.example.ddd_tips.application_service.application.order;

import java.util.List;

import com.farhad.example.ddd_tips.application_service.application.client.ClientAccessException;
import com.farhad.example.ddd_tips.application_service.application.client.ClientProvider;
import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;
import com.farhad.example.ddd_tips.application_service.domain.model.order.Order;
import com.farhad.example.ddd_tips.application_service.domain.model.order.OrderAccessPolicy;
import com.farhad.example.ddd_tips.application_service.domain.model.order.OrderRepository;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {
    
    private final ClientProvider clientProvider;
    private final OrderRepository orderRepository;
    private final OrderAccessPolicy orderAccessPolicy;

    // Create order with empty product basket
    // then add produts to order
    // then get client 
    // then Check if client can make an order according to given policies
    // Place order
    public Order placeOrder(@NonNull List<Product> products, @NonNull String clientId){
        Order order = Order.init(clientId);
        order.add(products);
        clientProvider.fetchClient(clientId)
            .map(client -> placeOrderFor(order, client))
            .orElseThrow(() ->  
                new ClientAccessException(
                    "Client with given id " + clientId + "not found!"));

        return orderRepository.save(order);
    }

    private Order placeOrderFor(Order order, Client client) {
        return order.place(client, orderAccessPolicy)
            .orElseGet(() -> handleOrderPlacementFailure(order));
    }

    private Order handleOrderPlacementFailure(Order order) {
        return order.reject();
    }
}
