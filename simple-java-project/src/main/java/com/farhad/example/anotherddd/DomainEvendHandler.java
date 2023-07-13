package com.farhad.example.anotherddd;

public interface DomainEvendHandler<T> {

    public void handle(T t);
}
