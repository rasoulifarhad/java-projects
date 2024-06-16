package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @Test
    public void asStringReturnUSD() {
        Currency subject = new Currency("USD");

        String actual = subject.asString();

        assertEquals("USD", actual);
    }

    @Test
    public void asStringReturnAnythings() {
        Currency subject = new Currency("Anythings");

        String actual = subject.asString();

        assertEquals("Anythings", actual);
    }
}
