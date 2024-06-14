package com.farhad.example.another_money_example;

public abstract class Money {
    private int amount;
    private String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int value() {
        return amount;
    }

    public int times(int multiplicand) {
        return amount *multiplicand;
    }
    

}
