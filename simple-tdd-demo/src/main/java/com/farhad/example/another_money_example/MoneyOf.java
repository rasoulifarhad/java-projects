package com.farhad.example.another_money_example;

public abstract class MoneyOf extends Money {

    protected double amount;
    protected Currency currency;

    protected MoneyOf(double amount, Currency currency) {
        super();
        this.amount = amount;
        this.currency = currency;
    }


}
