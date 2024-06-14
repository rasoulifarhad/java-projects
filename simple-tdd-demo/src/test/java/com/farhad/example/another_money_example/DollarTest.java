package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DollarTest {

    @Test
    public void derivesFromMoney2() {
        Money money = Money.dollar(20);
    }

    @Test
    public void asStringReturnsValueAndCurrency2() {

        Money money = Money.dollar(20);
        String actual = money.asString();

        assertEquals("[amount=20][currency=USD]", actual);
    }
}
