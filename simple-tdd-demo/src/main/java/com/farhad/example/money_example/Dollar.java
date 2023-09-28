package com.farhad.example.money_example;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }
    
    public int getAmount() {
        return amount;
    }
}
