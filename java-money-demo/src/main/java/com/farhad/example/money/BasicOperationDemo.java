package com.farhad.example.money;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicOperationDemo {
    public static void main(String[] args) {
        CurrencyUnit dollar = Monetary.getCurrency(Locale.US);

        MonetaryAmount moneyOf120Dollar = Money.of(120, dollar);
        MonetaryAmount moneyOf50Dollar = Money.of(50,dollar);
        print(moneyOf120Dollar, moneyOf50Dollar, " + ", moneyOf120Dollar.add(moneyOf50Dollar));
        print(moneyOf120Dollar, moneyOf50Dollar, " - ", moneyOf120Dollar.subtract(moneyOf50Dollar));
        print(moneyOf120Dollar, moneyOf50Dollar, " * ", moneyOf120Dollar.multiply(50));
        print(moneyOf120Dollar, moneyOf50Dollar, " / ", moneyOf120Dollar.divide(50));
        print(moneyOf120Dollar, moneyOf50Dollar, " == ", moneyOf120Dollar.isEqualTo(moneyOf50Dollar));
        print(moneyOf120Dollar, moneyOf50Dollar, " > ", moneyOf120Dollar.isGreaterThan(moneyOf50Dollar));
        print(moneyOf120Dollar, moneyOf50Dollar, " >= ", moneyOf120Dollar.isGreaterThanOrEqualTo(moneyOf50Dollar));
        print(moneyOf120Dollar, moneyOf50Dollar, " <= ", moneyOf120Dollar.isLessThanOrEqualTo(moneyOf50Dollar));

        log.info("{} {}", moneyOf120Dollar, moneyOf50Dollar.isNegative() ? "is negative" : "is positive"  );

        MonetaryAmount fastMoney = FastMoney.of(80, dollar);
        log.info("{}", fastMoney);
    }

    private static void print(MonetaryAmount amount1, MonetaryAmount amount2, String op, Object result) {
        log.info("{} {} {} = {}",
            amount1, 
            op, 
            amount2, 
            result);
    }
}
