package com.farhad.example.money_example;

public class Dollar extends Money {

    private String currency;

    public Dollar(int amount) {
        this.amount = amount;
        this.currency = "USD";
    }
    
    public Money times(int multiplier) {

        return new Dollar(this.amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    String currency() {
        return currency;
    }
}
