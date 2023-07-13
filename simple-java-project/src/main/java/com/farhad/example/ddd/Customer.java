package com.farhad.example.ddd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Customer {
    
    @Getter
    @EqualsAndHashCode.Include
    private final String firstname;
    @Getter
    @EqualsAndHashCode.Include
    private final String lastname;
    @Getter
    @EqualsAndHashCode.Include
    private final String province;
    

    private List<Order> orders = new ArrayList<>(); 

    public Iterable<Order> orders() {
        return Collections.unmodifiableList(orders);
    } 
    public void addOrder(Order order) {
        Objects.requireNonNull(order);
        orders.add(order);
    }

}
