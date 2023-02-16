package com.farhad.example.dispatch.doubledispatch.ddd;

public class FixedDiscountPolicy implements DiscountPolicy{

    @Override
    public double discount(Order order) {
        return 0.01;
    }
    
}
