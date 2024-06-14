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

        Money money = Money.euro(9.7);
        String actual = money.asString();

        assertEquals("[amount=9.7][currency=EUR]", actual);
    }

}
