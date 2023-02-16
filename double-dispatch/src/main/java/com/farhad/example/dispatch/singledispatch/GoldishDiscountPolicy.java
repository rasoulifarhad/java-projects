package com.farhad.example.dispatch.singledispatch;

public interface GoldishDiscountPolicy extends DiscountPolicy {

    double discount(GoldishOrder order) ;
    
}
