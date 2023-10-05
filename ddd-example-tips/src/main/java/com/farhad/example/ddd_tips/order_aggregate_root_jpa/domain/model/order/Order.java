package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.order;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base.Address;
import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base.Amount;
import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.customer.Customer;

import lombok.Data;

@Data
public class Order {

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    private Instant orderDate;
    private Address shippingAdress;
    private Amount totalPrice;
    private Amount shippingCost;
    private Amount salesTax;

    public List<OrderItem> getOrderItems() {
        return new ArrayList<>(orderItems);
    }
}
