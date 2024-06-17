package com.farhad.example.another_money_example;

import static com.farhad.example.another_money_example.Currency.DefaultCurrency.Euro;
import static com.farhad.example.another_money_example.Currency.DefaultCurrency.KoreanWon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void asStringExists() {
        Money money = new UsDollar(20);
        String actual = money.asString();
        assertEquals("[amount=20.0][currency=USD]", actual);
    }

    @Test
    public void fiveCurrencyPlus10CurrencyShouldBe15Currency() {
        Money five = new UsDollar(5);
        Money ten = new UsDollar(10);
        Money actual = five.plus(ten);
        assertEquals(new UsDollar(15), actual);
    }

    @Test
    public void moneyTimes() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int multiplicand =  1 + new Random().nextInt(20);
        Money subject = new UsDollar(value);
        Money actual = subject.times(multiplicand);
        assertEquals(new UsDollar(value * multiplicand), actual);
    }

    @Test
    public void divideMoney() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int divisor =  1 + new Random().nextInt(20);
        Money subject = new UsDollar(value);
        Money actual = subject.divide(divisor);
        assertEquals(new UsDollar(value / divisor), actual);
    }

    @Test
    public void moneyEqualsSameMoney() {
        Money subject = new Euro(12.0);
        boolean actual = subject.equals(new Euro(12.0));
        assertTrue(actual);
    }

    @Test
    @Disabled
    public void eurosAndWonAreNotEqual() {
        assertFalse(new Euro(12.0).equals(new KoreanWon(12.0)));
    }

    @Test
    public void SameTypesAreEqual() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        List<Money> source = new ArrayList<>(Arrays.asList(new Euro(value), new KoreanWon(value), new UsDollar(value)));
        List<Money> compare = new ArrayList<>(Arrays.asList(new Euro(value), new KoreanWon(value), new UsDollar(value)));
        int index = new Random().nextInt(source.size());
        boolean actual = source.get(index).equals(compare.get(index));
        assertTrue(actual);
    }

    @Test
    public void fiveDollarsPlusTenEuroShouldBeSeventeenDollars() {
        Money fiveDollar = new UsDollar(5.5);
        Money tenEuro = new Euro(10);

        Money actual = fiveDollar.plus(tenEuro);
        Money expected = new UsDollar(17.5);
        assertTrue(actual.equals(expected));
    }

    @Test
    // @Disabled
    public void differentCurrenciesAreEqualWhenExchangeIsRight() {
        Money tenDollar = new UsDollar(10);
        Money twelveEuro = new Euro(12);
        boolean actual = twelveEuro.equals(tenDollar);

        assertTrue(actual);
    }

    @Test
    public void differentCurrenciesOfSameValueAreNotEqual() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        Money euro = new Euro(value);
        Money dollar = new UsDollar(value);

        boolean actual = euro.equals(dollar);
        assertFalse(actual);
    }

    @Test
    public void convertFromUsdToWon() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        Money subject = new UsDollar(value);

        Money actual = subject.to(KoreanWon);
        assertEquals(new KoreanWon(value * 1100), actual);
    }

    @Test
    public void convertFromDollarToEuro() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        Money subject = new UsDollar(value);
        Money actual = subject.to(Euro);
        assertEquals(new Euro(value * 1.2), actual);
    }

    @Test
    public void sameTypesAreEqual() {
        double value = Double.valueOf(1 + new Random().nextInt(20));

        List<Money> source = new ArrayList<>(
            Arrays.asList(
                new Euro(value), new KoreanWon(value), new UsDollar(value)));

        List<Money> compare = new ArrayList<>(
            Arrays.asList(
                new Euro(value), new KoreanWon(value), new UsDollar(value)));

        int index = new Random().nextInt(source.size());
        boolean actual = source.get(index).equals(compare.get(index));
        assertTrue(actual);
    }


}
