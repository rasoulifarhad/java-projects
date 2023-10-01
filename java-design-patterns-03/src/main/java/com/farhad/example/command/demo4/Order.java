package com.farhad.example.command.demo4;

import lombok.Data;

// Receiver
@Data
public class Order {
    
    private String foodItem;
    private Integer foodQuantity;

    private boolean orderPlaced;
    private boolean orderValidated;
    private boolean orderPrepared;
    private boolean orderServed;
    
    public Order(String foodItem, Integer foodQuantity) {
        this.foodItem = foodItem;
        this.foodQuantity = foodQuantity;
    }

    
}
