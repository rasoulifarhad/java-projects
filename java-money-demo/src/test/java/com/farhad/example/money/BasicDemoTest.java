package com.farhad.example.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.MathContext;
import java.math.RoundingMode;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryContextBuilder;
import javax.money.MonetaryException;
import javax.money.MonetaryRounding;
import javax.money.RoundingQueryBuilder;
import javax.money.UnknownCurrencyException;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class BasicDemoTest {

    @Test
    public void demonstrateCurrencyCode() {
        CurrencyUnit usd = Monetary.getCurrency("USD");
        assertNotNull(usd);
        assertEquals(usd.getCurrencyCode(), "USD");
        assertEquals(usd.getNumericCode(), 840);
        assertEquals(usd.getDefaultFractionDigits(), 2);

        assertThrows(
            UnknownCurrencyException.class,
            () -> Monetary.getCurrency("AAA"));
    }

    @Test
    public void demonstrateMoneyStringified() {
        CurrencyUnit usd = Monetary.getCurrency("USD");
        MonetaryAmount fstAmtUSD = 
            Monetary.getDefaultAmountFactory()
                .setCurrency(usd)
                .setNumber(200)
                .create();
        Money moneyof = Money.of(12, usd);
        FastMoney fastmoneyof = FastMoney.of(2, usd);
        assertEquals("USD", usd.toString());
        assertEquals("USD 200.00", fstAmtUSD.toString());
        assertEquals("USD 12.00", moneyof.toString());
        assertEquals("USD 2.00", fastmoneyof.toString());
    }

    @Test
    public void demonstrateEquality() {

        MonetaryAmount oneDollar = 
            Monetary.getDefaultAmountFactory()
                .setCurrency("USD")
                .setNumber(1)
                .create();
        Money oneEuro = Money.of(1, "EUR");

        assertFalse(oneEuro.equals(FastMoney.of(1, "EUR") ));
        assertTrue(oneDollar.equals(Money.of(1, "USD")));
    }

    @Test
    public void demonstrateMonetaryAmountFactory() {
        FastMoney fstMoney = Monetary.getAmountFactory(FastMoney.class)
                                        .setCurrency("USD")
                                        .setNumber(200.20)
                                        .create();
        FastMoney fstMoney2 = FastMoney.of(200.20, "USD");
        assertEquals(fstMoney, fstMoney2);

        Money m1 = Monetary.getAmountFactory(Money.class)
                                .setCurrency("USD")
                                .setNumber(200.20)
                                .create();
        Money m2 = Money.of(200.20, "USD");
        assertEquals(m1, m2);
    }

    @Test
    public void demonstrateConfiguringInstancesOfMoney() {
        Money m1 = Money.of(200, 
                                "CHF", 
                                MonetaryContextBuilder.of().set(MathContext.DECIMAL128).build() );
        Money m2 = Monetary.getAmountFactory(Money.class)
                                .setCurrency("CHF")
                                .setNumber(200)
                                .setContext(MonetaryContextBuilder.of().set(MathContext.DECIMAL128).build())
                                .create();
        assertEquals(m1, m2);
    }


    @Test
    public void demonstrateMonetaryException() {
        MonetaryAmount us = Money.of(100.00, "USD");
        MonetaryAmount canada = Money.of(20.00, "CAD");

        assertThrows(MonetaryException.class, () -> canada.add(us));
    }

    @Test
    public void demonstrateCasting() {
        FastMoney fst = FastMoney.of(200, "CHF");
        Money m1 = Money.of(200, "CHF");
        Money m2 = Money.from(fst);
        assertEquals(m1, m2);
    }

    @Test
    public void demonstrateBasicCalc() {
        Money m1 = Money.of(1, "EUR");
        m1 = m1.add(Money.of(1234567.3444, "EUR"));
        m1 = m1.subtract(Money.of(232323, "EUR"));
        m1 = m1.multiply(3.4);
        m1 = m1.divide(5.456);
        m1 = m1.with(Monetary.getDefaultRounding());
        System.out.println("m1: -----> " +   m1);
    }

    @Test
    public void demonstrateArithmeticRounding() {
        MonetaryRounding rounding = Monetary.getRounding(
                                        RoundingQueryBuilder.of()
                                            .setScale(4)
                                            .set(RoundingMode.HALF_UP)
                                            .build());
        MonetaryRounding defRounding = Monetary.getDefaultRounding();
        MonetaryRounding defRoundingForCurrency = Monetary.getRounding(Monetary.getCurrency("EUR"));
        MonetaryAmount amount = Money.of(1234567.3444, "EUR");
        MonetaryAmount roundedAmount = amount.with(rounding);
        MonetaryAmount defRoundedAmount = amount.with(defRounding);
        MonetaryAmount defCurrencyRoundedAmount = amount.with(defRoundingForCurrency);
        System.out.println(amount + " --> " + roundedAmount + " --> " + defRoundedAmount + " --> " + defCurrencyRoundedAmount)  ;

        rounding = 
            Monetary.getRounding(
                RoundingQueryBuilder.of()
                    .setCurrency(Monetary.getCurrency("CHF"))
                    .set("cashRounding", true)
                    .build());
        amount = Money.of(1234567.3444, "CHF");
        roundedAmount = amount.with(rounding);
    }
}
