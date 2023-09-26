package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderManagementService {
   
    private final OrderRepository orderRepository;

    public List<Order> handle(OrderQuery query) {
        return orderRepository.find(query);
    }

    public OrderDetails processPurchase(OrderRequest command) {
        return null;
    }
}
