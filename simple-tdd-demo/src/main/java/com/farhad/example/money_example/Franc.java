package com.farhad.example.money_example;

public class Franc extends Money {
  
    public Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = "CHF";
    }
    
    public Money times(int multiplier) {

        return new Franc(this.amount * multiplier, null);
    }

    public int getAmount() {
        return amount;
    }
}
