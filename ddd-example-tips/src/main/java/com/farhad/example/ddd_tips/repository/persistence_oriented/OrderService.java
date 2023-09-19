package com.farhad.example.ddd_tips.repository.persistence_oriented;

public class OrderService {
    OrderRepository orderRepository;

    public void doSomethingWithOrder(OrderId id) {
        orderRepository.findById(id)
                .ifPresent(order -> {
                    order.doSomething();
                    orderRepository.save(order);
                });
    }
}
