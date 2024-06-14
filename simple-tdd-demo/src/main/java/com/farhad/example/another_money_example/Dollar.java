package com.farhad.example.another_money_example;

public class Dollar {

    private int amount;
    private String currency;

    

    public Dollar(int amount) {
        this(amount, "USD");
    }

    public Dollar(int amount, String currency) {
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
