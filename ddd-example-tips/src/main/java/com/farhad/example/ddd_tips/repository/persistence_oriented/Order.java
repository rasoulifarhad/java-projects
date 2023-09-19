package com.farhad.example.ddd_tips.repository.persistence_oriented;

public class Order extends AggregateRoot<OrderId> {

    public Order(OrderId id) {
        super(id);
    }

    public void doSomething() {
    }

  
}
