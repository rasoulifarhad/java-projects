package com.farhad.example.tdd.order;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConfigurableOrderDatabase implements OrderDatabase {

    public Consumer<Order> doWhenInsertCalled;
    public Supplier<List<Order>> doWhenSelectAllOrdersCalled;


   
    @Override
    public void insert(Order order) throws Exception {
        doWhenInsertCalled.accept(order);
    }

    @Override
    public void connect() {
    }

    @Override
    public void clean() {
    }

    @Override
    public List<Order> selectAllOrders() {
        return doWhenSelectAllOrdersCalled.get();
    }

}
