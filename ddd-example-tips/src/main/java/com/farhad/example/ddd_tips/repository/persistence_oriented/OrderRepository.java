package com.farhad.example.ddd_tips.repository.persistence_oriented;

import java.util.Optional;

import org.springframework.data.domain.Page;


public interface OrderRepository {
     Optional<Order> findById(OrderId id);

    boolean exists(OrderId id);

    Order save(Order order);

    void delete(Order order);

    Page<Order> findAll(OrderSpecification specification, int offset, int size);
}
