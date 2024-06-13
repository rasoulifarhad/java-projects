package com.farhad.example.codekata.fizz_buzz_builder;

public abstract class AbstractFizzBuzz implements IFizzBuzz {

    protected IFizzBuzz _next;

    public AbstractFizzBuzz(IFizzBuzz _next) {
        this._next = _next;
    }

    
}
