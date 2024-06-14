package com.farhad.example.another_money_example;

public class Euro {

    private int amount;
    private String currency;

    public Euro(int amount) {
        this(amount, "EUR");
    }

    

    public Euro(int amount, String currency) {
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
