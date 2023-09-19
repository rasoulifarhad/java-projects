package com.farhad.example.ddd_tips.repository.collection_oriented;

import java.util.Optional;

import org.springframework.data.domain.Page;

public interface OrderRepository {
    Optional<Order> get(OrderId id);
    boolean contains(OrderId id);

    void add(Order order);

    void remove(Order order);
    Page<Order> search(OrderSpecification specification, int offset, int size);
}
