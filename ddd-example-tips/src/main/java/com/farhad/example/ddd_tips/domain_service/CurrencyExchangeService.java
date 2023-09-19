package com.farhad.example.ddd_tips.domain_service;

import java.util.Currency;

public interface CurrencyExchangeService {
    Money convertToCurrency(Money currentAmount, Currency desiredCurrency);
}
