package com.farhad.example.strategy.standard_approach;

public interface Strategy<X, Y> {
    public Y execute(X x);
}
