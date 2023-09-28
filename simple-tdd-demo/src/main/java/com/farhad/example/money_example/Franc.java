package com.farhad.example.money_example;

public class Franc extends Money {
  
    public Franc(int amount, String currency) {
        super(amount, currency);
    }
    
    public Money times(int multiplier) {

        return new Franc(this.amount * multiplier, currency);
    }

    public int getAmount() {
        return amount;
    }
}
