package com.farhad.example.tdd.order;

public class OrderProcessing {

    OrderDatabase orderDatabase;
    Log log;
  
    public OrderProcessing(OrderDatabase orderDatabase, Log log) {
        this.orderDatabase = orderDatabase;
        this.log = log;
    }

    public void place(Order order) {
        try {
            orderDatabase.insert(order);
        } catch (Exception e) {
            log.write("Could not insert an order. reason: " + e);
        }
    }
    
}
