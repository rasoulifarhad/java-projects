package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void euroReturnsConstructedValue() {
        int value = 1 + new Random().nextInt(20);
        TestMoney subject = new TestMoney(value, "USD");
        double actual = subject.value();

        assertEquals(value, actual);
    }

    @Test
    public void euroValueByMultiplicandShouldBeExpected() {
        int value = 1 + new Random().nextInt(20);
        int multiplicand =  1 + new Random().nextInt(20);
        TestMoney subject = new TestMoney(value, "USD");
        double actual = subject.times(multiplicand);
        assertEquals(value * multiplicand, actual);
    }

    @Test
    public void asStringExists() {

        Money money = new TestMoney(20, "CUR");
        String actual = money.asString();

        assertEquals("[amount=20.0][currency=CUR]", actual);
    }

    @Test
    public void divideExists() {
        Money subject = new TestMoney(4002, "CUR");
        double actual = subject.divide(4);
        assertEquals(1000.5, actual);
    }

    @Test
    public void divideExists2() {
        Money subject = new TestMoney(10000, "CUR");
        double actual = subject.divide(10);
        assertEquals(1000, actual);
    }

    private static class TestMoney extends Money {

        protected TestMoney(double amount, String currency) {
            super(amount, currency);
        }
    }
    
}
