package com.farhad.example.dispatch.doubledispatch.v1;

public interface Visitable<V> {
    public void accept(V visitor);
}
