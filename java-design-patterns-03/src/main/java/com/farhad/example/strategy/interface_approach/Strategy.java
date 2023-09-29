package com.farhad.example.strategy.interface_approach;

public interface Strategy<X, Y> {
    public Y execute(X x);
}
