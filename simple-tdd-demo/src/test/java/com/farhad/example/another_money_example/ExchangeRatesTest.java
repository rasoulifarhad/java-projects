package com.farhad.example.another_money_example;

import static com.farhad.example.another_money_example.Currency.DefaultCurrency.Fake;
import static com.farhad.example.another_money_example.Currency.DefaultCurrency.KoreanWon;
import static com.farhad.example.another_money_example.Currency.DefaultCurrency.UsDollar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.farhad.example.another_money_example.ExchangeRates.InMemoryExchangeRates;

public class ExchangeRatesTest {

    @Test
    public void NoExchangeRateIsException() {
        ExchangeRates subject = new InMemoryExchangeRates();

        assertThrows(NoExchangeRateAvailableException.class, () -> {
            subject.from(UsDollar).to(Fake);
        });
    }

    @Test
    public void NoFromExchangeRateIsException() {
        ExchangeRates subject = new InMemoryExchangeRates();

        assertThrows(NoExchangeRateAvailableException.class, () -> {
            subject.from(Fake);
        });

    }

    @Test
    public void fiveDollarsPlusTenEuroShouldBeSeventeenDollars() {
        Money fiveDollar = new UsDollar(5);
        Money tenEuro = new Euro(10);

        Money actual = fiveDollar.plus(tenEuro);

        assertEquals(new UsDollar(17), actual);
    }

    @Test
    public void exchangeFromUsdToKrw() {
        ExchangeRates subject = new InMemoryExchangeRates();

        double actual = subject.from(UsDollar).to(KoreanWon);
        assertEquals(1100, actual);
    }


}
