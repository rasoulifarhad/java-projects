package com.farhad.example.dispatch.doubledispatch.ddd;


public interface DiscountPolicy {
    
    double discount(Order order);
}
