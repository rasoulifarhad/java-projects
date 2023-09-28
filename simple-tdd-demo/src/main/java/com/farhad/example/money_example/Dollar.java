package com.farhad.example.money_example;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }
    
    public Money times(int multiplier) {

        return Money.dollar(this.amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }
}
