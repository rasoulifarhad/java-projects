package com.farhad.example.dispatch.doubledispatch.v1;

import java.util.List;

import lombok.Getter;

@Getter
public class Order implements Visitable<OrderVisitor>{

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }

    private final List<OrderLine> orderLines; 
    private  Money cost;

    protected Order(List<OrderLine> orderLines){
        this.orderLines = orderLines;
        cost = orderLines.stream()
                                .map( ol -> ol.getProduct().getPrice() )
                                .reduce(Money::add)
                                .get();
    }
    
    public static Order orderOfOneProduct500() {
        return
                new Order(OrderLine.oneProduct500());
    }

    public static Order orderOfOneProduct501() {
        return
                new Order(OrderLine.oneProduct501());
    }

}
