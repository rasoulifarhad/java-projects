package com.farhad.example.another_money_example;

public interface IExchangeRates {

    double exchangeRate(String toCurrency, String fromCurrency);
    IExchangeRateTo from(String currency);
    IExchangeRateTo from(Currency currency);;
}