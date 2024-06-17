package com.farhad.example.another_money_example;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

public class Euro  extends Money  {

    public Euro(double amount) {
        super(amount, DefaultCurrency.Euro);
    }

}
