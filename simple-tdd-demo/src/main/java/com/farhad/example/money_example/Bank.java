package com.farhad.example.money_example;

public class Bank {

    public Money reduce(Expression source, String to) {
        if (source instanceof Money) {
            Money money = (Money) source;
            return money.reduce(to);
        }
        Sum sum = (Sum) source;
        return sum.reduce(to);
    }
    
}
