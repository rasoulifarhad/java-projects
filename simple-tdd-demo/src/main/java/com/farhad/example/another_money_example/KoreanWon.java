package com.farhad.example.another_money_example;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

public class KoreanWon extends MoneyOf {

    public KoreanWon(double amount) {
        super(amount, DefaultCurrency.KoreanWon);
    }
    @Override
    protected double amountValue() {
        return amount;
    }

    @Override
    protected Currency currencyValue() {
        return currency;
    }

}
