package com.farhad.example.dispatch.doubledispatch.ddd;

public interface Visitable<V> {
    public void accept(V visitor);
}
