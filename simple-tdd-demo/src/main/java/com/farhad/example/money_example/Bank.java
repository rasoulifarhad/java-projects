package com.farhad.example.money_example;

public class Bank {

    public Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        return sum.reduce(to);
    }
    
}
