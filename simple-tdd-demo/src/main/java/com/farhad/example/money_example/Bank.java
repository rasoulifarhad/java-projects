package com.farhad.example.money_example;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Pair, Integer> rates = new HashMap<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    int rate(String from, String to) {
        Integer rate = rates.get(new Pair(from, to));
        return rate.intValue();
    }
    public void addRate(String from, String to, int rate) {

        rates.put(new Pair(from, to), new Integer(rate));
    }
    
}
