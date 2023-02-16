package com.farhad.example.dispatch.doubledispatch.ddd;

import java.util.List;

public class GoldishOrder extends Order {

    // public void accept(OrderVisitor visitor) {
    //     visitor.visit(this);
    // }

    private GoldishOrder(List<OrderLine> orderLines){
        super(orderLines);
    }

    protected double applyDiscountPolicy(GoldishDiscountPolicy discountPolicy) {

        return discountPolicy.discount(this);

    }

    public static GoldishOrder orderOfOneProduct500() {
        return
                new GoldishOrder(OrderLine.oneProduct500());
    }

    public static GoldishOrder orderOfOneProduct501() {
        return
                new GoldishOrder(OrderLine.oneProduct501());
    }
}
