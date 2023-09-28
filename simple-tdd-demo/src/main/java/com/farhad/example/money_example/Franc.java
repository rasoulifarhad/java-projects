package com.farhad.example.money_example;

public class Franc extends Money {
  
    public Franc(int amount, String currency) {
        super(amount, currency);
    }
    
    public int getAmount() {
        return amount;
    }
}
