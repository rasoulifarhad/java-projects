package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void asStringExists() {
        Money money = new Money(20, "CUR");
        String actual = money.asString();
        assertEquals("[amount=20.0][currency=CUR]", actual);
    }

    @Test
    public void fiveCurrencyPlus10CurrencyShouldBe15Currency() {
        Money five = new Money(5, "CUR");
        Money ten = new Money(10, "CUR");
        Money actual = five.plus(ten);
        assertEquals("[amount=15.0][currency=CUR]", actual.asString());
    }

    @Test
    public void moneyTimes() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int multiplicand =  1 + new Random().nextInt(20);
        Money subject = new Money(value, "CUR");
        Money actual = subject.times(multiplicand);
        assertEquals(String.format("[amount=%s][currency=CUR]", value * multiplicand), actual.asString());
    }

    @Test
    public void divideMoney() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int divisor =  1 + new Random().nextInt(20);
        Money subject = new Money(value, "CUR");
        Money actual = subject.divide(divisor);
        assertEquals(String.format("[amount=%.1f][currency=CUR]", value / divisor), actual.asString());
    }

}
