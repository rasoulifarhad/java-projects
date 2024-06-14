package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EuroTest {


    @Test
    public void derivesFromMoney() {
        Money money = Money.euro(20);
    }

    @Test
    public void asStringReturnsValueAndCurrency() {

        Money money = Money.euro(20);
        String actual = money.asString();

        assertEquals("[amount=20.0][currency=EUR]", actual);
    }

    @Test
    public void euroTakesDouble() {
        Money money = Money.euro(20.5);
        String actual = money.asString();
        assertEquals("[amount=20.5][currency=EUR]", actual);
    }

}
