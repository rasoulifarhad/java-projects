package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void asStringExists() {
        Money money = Money.dollar(20);
        String actual = money.asString();
        assertEquals("[amount=20.0][currency=USD]", actual);
    }

    @Test
    public void fiveCurrencyPlus10CurrencyShouldBe15Currency() {
        Money five = Money.dollar(5);
        Money ten = Money.dollar(10);
        Money actual = five.plus(ten);
        assertEquals("[amount=15.0][currency=USD]", actual.asString());
    }

    @Test
    public void moneyTimes() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int multiplicand =  1 + new Random().nextInt(20);
        Money subject = Money.dollar(value);
        Money actual = subject.times(multiplicand);
        assertEquals(String.format("[amount=%s][currency=USD]", value * multiplicand), actual.asString());
    }

    @Test
    public void divideMoney() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int divisor =  1 + new Random().nextInt(20);
        Money subject = Money.dollar(value);
        Money actual = subject.divide(divisor);
        assertEquals(String.format("[amount=%.1f][currency=USD]", value / divisor), actual.asString());
    }

}
