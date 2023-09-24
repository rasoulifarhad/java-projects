package com.farhad.example.property;

public interface Prototype {
    Integer get(Stats stat);
    boolean has(Stats stat);
    void set(Stats stat, Integer value);
    void remove(Stats stat);
}
