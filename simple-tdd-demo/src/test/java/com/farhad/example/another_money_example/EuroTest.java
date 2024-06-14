package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EuroTest {


    @Test
    public void derivesFromMoney() {
        Money money = new Euro(20);
    }

        @Test
    public void asStringReturnsValueAndCurrency() {

        Money money = new Euro(20);
        String actual = money.asString();

        assertEquals("[amount=20][currency=EUR]", actual);
    }

}
