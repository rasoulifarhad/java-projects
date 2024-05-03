package com.farhad.example.tdd.order;

import java.util.ArrayList;
import java.util.List;

public class ExplodingOrderDatabase implements OrderDatabase {

    @Override
    public void insert(Order order) throws Exception {
        throw new Exception();
    }

    @Override
    public void connect() {
    }

    @Override
    public void clean() {
    }

    @Override
    public List<Order> selectAllOrders() {
        return new ArrayList<>();
    } 

}
