package com.farhad.example.dispatch.doubledispatch.v1;

public interface OrderVisitor {
    public void visit(Order order);
    public void visit(GoldishOrder order );
}
