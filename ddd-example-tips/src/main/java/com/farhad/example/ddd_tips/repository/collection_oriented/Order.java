package com.farhad.example.ddd_tips.repository.collection_oriented;

public class Order extends AggregateRoot<OrderId> {

    public Order(OrderId id) {
        super(id);
    }

    public Object doSomething() {
        return null;
    }

  
}