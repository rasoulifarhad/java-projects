package com.farhad.example.another_money_example;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

// The below Knowledge Class is a concept that exists in the code - An Amount of US 
// Dollars. When we limit it to creation by new Money(value, DefaultCurrency.UsDollar) 
// then the concept of "An Amount of US Dollars" isn't represented in our code. It 
// exists in our code, clearly - We're creating it right there. We are creating that 
// concept, but it doesn't exist in the code-base itself.
public class UsDollar extends MoneyOf {

    public UsDollar(double amount) {
        super(amount, DefaultCurrency.UsDollar);
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
