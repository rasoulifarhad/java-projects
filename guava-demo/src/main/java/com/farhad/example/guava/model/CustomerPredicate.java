package com.farhad.example.guava.model;

import com.google.common.base.Predicate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class CustomerPredicate implements Predicate<CustomerSpecific>, CustomerSpecific  {

    private final Customer customer;
    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean apply(CustomerSpecific specific) {
        return specific.getCustomer().equals(customer);
    }
    
    public CustomerPredicate withName(String name) {
        return CustomerPredicate.of(new Customer(name));
    }
}
