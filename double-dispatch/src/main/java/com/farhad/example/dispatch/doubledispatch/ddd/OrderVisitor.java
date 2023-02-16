package com.farhad.example.dispatch.doubledispatch.ddd;

public interface OrderVisitor {
    public void visit(Order order);
    public void visit(GoldishOrder order );
}
