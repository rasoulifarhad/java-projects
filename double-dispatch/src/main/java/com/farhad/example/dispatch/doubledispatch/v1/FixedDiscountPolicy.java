package com.farhad.example.dispatch.doubledispatch.v1;

public class FixedDiscountPolicy implements DiscountPolicy{

    @Override
    public double discount(Order order) {
        return 0.01;
    }
    
}
