package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        assertEquals(Money.dollar(15), actual);
    }

    @Test
    public void moneyTimes() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int multiplicand =  1 + new Random().nextInt(20);
        Money subject = Money.dollar(value);
        Money actual = subject.times(multiplicand);
        assertEquals(Money.dollar(value * multiplicand), actual);
    }

    @Test
    public void divideMoney() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        int divisor =  1 + new Random().nextInt(20);
        Money subject = Money.dollar(value);
        Money actual = subject.divide(divisor);
        assertEquals(Money.dollar(value / divisor), actual);
    }

    @Test
    public void moneyEqualsSameMoney() {
        Money subject = Money.euro(12.0);
        boolean actual = subject.equals(Money.euro(12.0));
        assertTrue(actual);
    }

    @Test
    public void eurosAndWonAreNotEqual() {
        assertFalse(Money.euro(12.0).equals(Money.won(12.0)));
    }

    @Test
    public void differentTypesAreNotEqual() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        Money usd = Money.dollar(value);
        Money eur = Money.euro(value);
        Money won = Money.won(value);
        List<Money> shuffled = new ArrayList<>(Arrays.asList(usd, eur, won));
        Collections.shuffle(shuffled);
        boolean actual = shuffled.get(0).equals(shuffled.get(1));
        assertFalse(actual);
    }

    @Test
    public void SameTypesAreEqual() {
        double value = Double.valueOf(1 + new Random().nextInt(20));
        List<Money> source = new ArrayList<>(Arrays.asList(Money.euro(value), Money.won(value), Money.dollar(value)));
        List<Money> compare = new ArrayList<>(Arrays.asList(Money.euro(value), Money.won(value), Money.dollar(value)));
        int index = new Random().nextInt(source.size());
        boolean actual = source.get(index).equals(compare.get(index));
        assertTrue(actual);
    }

    @Test
    public void fiveDollarsPlusTenEuroShouldBeSeventeenDollars() {
        Money fiveDollar = Money.dollar(5);
        Money tenEuro = Money.euro(10);

        Money actual = fiveDollar.plus(tenEuro);

        assertEquals(Money.dollar(17), actual);
    }

    @Test
    public void fiveDollarsPlusTenWonShouldBe20Dollars() {
        Money fiveDollar = Money.dollar(5);
        Money tenWon = Money.won(10);

        Money actual = fiveDollar.plus(tenWon);

        assertEquals(Money.dollar(20), actual);
    }

    @Test
    public void NoExchangeRateIsException() {
        ExchangeRates subject = new ExchangeRates();


        assertThrows(NoExchangeRateAvailableException.class, () -> {
            subject.exchangeRate("USD", "BLA_BLA_BLAAAAA");
        });
    }
}
