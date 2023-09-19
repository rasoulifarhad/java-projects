package com.farhad.example.ddd_tips.repository.collection_oriented;

public class OrderService {
    OrderRepository orderRepository;

    public void doSomethingWithOrder(OrderId id) {
        orderRepository.get(id).ifPresent(order ->  order.doSomething());
    }
}
