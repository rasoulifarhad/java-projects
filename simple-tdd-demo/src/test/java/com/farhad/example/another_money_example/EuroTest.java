package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EuroTest {


    @Test
    public void derivesFromMoney() {
        Money money = new EuroDepricated(20);
    }

    @Test
    public void asStringReturnsValueAndCurrency() {

        Money money = new EuroDepricated(20);
        String actual = money.asString();

        assertEquals("[amount=20][currency=EUR]", actual);
    }

    @Test
    public void derivesFromMoney2() {
        Money money = Money.euro(20);
    }

    @Test
    public void asStringReturnsValueAndCurrency2() {

        Money money = Money.euro(20);
        String actual = money.asString();

        assertEquals("[amount=20][currency=EUR]", actual);
    }

}
