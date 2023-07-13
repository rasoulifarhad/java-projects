package com.farhad.example.ddd;

import lombok.Data;

@Data

public class Order {
    
    private String billingProvince;
    private final Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
        customer.addOrder(this);
    }
    public boolean isLocal() {
        return customer.getProvince().equals(billingProvince);
    }
}
