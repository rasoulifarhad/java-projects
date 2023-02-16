package com.farhad.example.dispatch.doubledispatch.v1;

import lombok.Getter;

@Getter
public class HtmlOrderViewCreator implements OrderVisitor{

    private String html;

    @Override
    public void visit(Order order) {
        html = String.format("<p>Regular order total cost: %s</p>", order.getCost());
    }

    @Override
    public void visit(GoldishOrder order) {
        html = String.format("<h1>Goldish user order</h1><p> total cost: %s</p>", order.getCost());
        
    }
    
}
