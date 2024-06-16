package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

public class CurrencyTest {

    @Test
    public void asStringReturnUSD() {
        Currency subject = DefaultCurrency.UsDollar;
        String actual = subject.asString();

        assertEquals("USD", actual);
    }

    @Test
    public void UsdAsCurrency()
    {
        Currency subject = DefaultCurrency.UsDollar;

        String actual = subject.asString();

        assertEquals("USD", actual);
    }
}