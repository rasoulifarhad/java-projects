package com.farhad.example.another_money_example;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

public class KoreanWon extends Money {

    public KoreanWon(double amount) {
        super(amount, DefaultCurrency.KoreanWon);
    }

}
