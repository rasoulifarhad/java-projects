package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void asStringExists() {
        Money money = new TestMoney(20, "CUR");
        String actual = money.asString();
        assertEquals("[amount=20.0][currency=CUR]", actual);
    }

    @Test
    public void moneyTimes() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int multiplicand =  1 + new Random().nextInt(20);
        TestMoney subject = new TestMoney(value, "CUR");
        double actual = subject.times(multiplicand);
        assertEquals(value * multiplicand, actual);
    }

    @Test
    public void moneyTimesMoney() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int multiplicand =  1 + new Random().nextInt(20);
        TestMoney subject = new TestMoney(value, "CUR");
        Money actual = subject.timesMoney(multiplicand);
        assertEquals(String.format("[amount=%s][currency=CUR]", value * multiplicand), actual.asString());
    }

    @Test
    public void divideExists() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int divisor =  1 + new Random().nextInt(20);
        TestMoney subject = new TestMoney(value, "USD");
        double actual = subject.divide(divisor);
        assertEquals(value / divisor, actual);
    }

    @Test
    public void fiveCurrencyPlus10CurrencyShouldBe15Currency() {
        Money five = new TestMoney(5, "CUR");
        Money ten = new TestMoney(10, "CUR");

        Money actual = five.plus(ten);
        assertEquals("[amount=15.0][currency=CUR]", actual.asString());
    }
    

    private static class TestMoney extends Money {

        protected TestMoney(double amount, String currency) {
            super(amount, currency);
        }

    }

}
