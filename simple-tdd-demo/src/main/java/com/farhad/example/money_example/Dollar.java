package com.farhad.example.money_example;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        this.amount = amount;
        this.currency = "USD";
    }
    
    public Money times(int multiplier) {

        return new Dollar(this.amount * multiplier, null);
    }

    public int getAmount() {
        return amount;
    }
}
