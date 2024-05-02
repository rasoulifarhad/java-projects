package com.farhad.example.tdd.order;

import java.util.Arrays;
import java.util.List;

public class FakeOrderDatabase  implements OrderDatabase {


    public Order receivedArgument;


    @Override
    public void insert(Order order) throws Exception {
        receivedArgument = order;
    }

    @Override
    public void connect() {
    }

    @Override
    public void clean() {
        receivedArgument = null;
    }

    @Override
    public List<Order> selectAllOrders() {
        return Arrays.asList(receivedArgument);
    }

}
