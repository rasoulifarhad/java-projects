package com.farhad.example.tdd.order;

import java.time.Instant;

public class Order {

    final String name;
    final String surname;
    final String product;
    final Instant instant;
    final int quantity;
    
    public Order(String name, String surname, String product, Instant instant, int quantity) {
        this.name = name;
        this.surname = surname;
        this.product = product;
        this.instant = instant;
        this.quantity = quantity;
    }

    
}
