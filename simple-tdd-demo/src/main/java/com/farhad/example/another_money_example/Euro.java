package com.farhad.example.another_money_example;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

public class Euro  extends MoneyOf  {

    public Euro(double amount) {
        super(amount, DefaultCurrency.Euro);
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
