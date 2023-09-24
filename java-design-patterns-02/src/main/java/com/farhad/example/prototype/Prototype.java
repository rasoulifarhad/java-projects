package com.farhad.example.prototype;

public abstract class Prototype implements Cloneable {

    @Override
    public abstract Object clone() throws CloneNotSupportedException;
    
}
