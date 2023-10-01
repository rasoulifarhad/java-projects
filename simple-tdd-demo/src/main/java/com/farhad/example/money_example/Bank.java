package com.farhad.example.money_example;

public class Bank {

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    int rate(String from, String to) {
        return from.equals("CHF") && to.equals("USD")
                    ? 2
                    : 1;
    }
    public void addRate(String string, String string2, int i) {
    }
    
}
