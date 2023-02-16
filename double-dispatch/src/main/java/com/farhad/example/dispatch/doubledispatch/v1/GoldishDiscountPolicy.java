package com.farhad.example.dispatch.doubledispatch.v1;

public interface GoldishDiscountPolicy extends DiscountPolicy {

    double discount(GoldishOrder order) ;
    
}
