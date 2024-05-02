package com.farhad.example.tdd.order;

import java.util.List;

public interface OrderDatabase {

    void insert(Order order) throws Exception;

    void connect();

    void clean();

    List<Order> selectAllOrders();


}
