package com.farhad.example.dispatch.doubledispatch.ddd;

public interface GoldishDiscountPolicy extends DiscountPolicy {

    double discount(GoldishOrder order) ;
    
}
