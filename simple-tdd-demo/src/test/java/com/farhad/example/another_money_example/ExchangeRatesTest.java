package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExchangeRatesTest {

    @Test
    public void NoExchangeRateIsException() {
        ExchangeRates subject = new ExchangeRates();


        assertThrows(NoExchangeRateAvailableException.class, () -> {
            subject.exchangeRate("USD", "BLA_BLA_BLAAAAA");
        });
    }

}
