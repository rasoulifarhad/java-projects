package com.farhad.example.command.demo3;

import java.util.ArrayList;
import java.util.List;

//invoker
public class Broker {

    List<Order> orders = new ArrayList<>();
    
    public void takeOrder(Order order) {
        orders.add(order);
    }

    public void placeOrders() {
        orders.forEach(Order::execute);
    }
}
