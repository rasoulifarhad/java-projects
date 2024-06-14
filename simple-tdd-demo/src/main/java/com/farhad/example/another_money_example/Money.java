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

    public String asString() {
        return String.format("[amount=%s][currency=%s]",amount, currency);
        // if(currency.equals("USD")) {
        //     return  "[amount=20][currency=USD]";
        // }
        // if(currency.equals("EUR")) {
        //     return  "[amount=20][currency=EUR]";
        // }
        // return "[amount=20][currency=CUR]";
    }
    

}
