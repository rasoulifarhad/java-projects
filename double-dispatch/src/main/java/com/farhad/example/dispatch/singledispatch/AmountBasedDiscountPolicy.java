package com.farhad.example.dispatch.singledispatch;

public class AmountBasedDiscountPolicy implements DiscountPolicy {

    @Override
    public double discount(Order order) {

        if(order.getCost().isGreaterThan(Money.of(500.00, CurrencyUnit.USD)))
            return 0.10;
        return 0;
    }
    
}
