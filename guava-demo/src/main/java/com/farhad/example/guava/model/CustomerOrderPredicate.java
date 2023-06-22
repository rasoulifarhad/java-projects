package com.farhad.example.guava.model;

import java.util.Objects;

import com.google.common.base.Predicate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class CustomerOrderPredicate implements Predicate<PurchaseOrder>{

    private final Customer customer;
    @Override
    public boolean apply(PurchaseOrder order) {
        Objects.requireNonNull(order);
        return customer.equals(order.getCustomer());
    }
    
}
