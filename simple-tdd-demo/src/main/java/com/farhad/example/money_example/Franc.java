package com.farhad.example.money_example;

public class Franc extends Money {
  
    private String currency;

    public Franc(int amount) {
        this.amount = amount;
        this.currency = "CHF";
    }
    
    public Money times(int multiplier) {

        return new Franc(this.amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    String currency() {
        return currency;
    }
    
}
