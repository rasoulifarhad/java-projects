package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WonTest {

    @Test
    public void wonExists() {
        Money money = Money.won(20);
    }

    @Test
    public void asStringReturnsValueAndCurrency() {

        Money money = Money.won(9.7);
        String actual = money.asString();

        assertEquals("[amount=9.7][currency=KRW]", actual);
    }

}
