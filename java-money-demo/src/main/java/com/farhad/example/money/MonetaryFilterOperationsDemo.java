package com.farhad.example.money;

import static java.util.stream.Collectors.toList;
import static org.javamoney.moneta.function.MonetaryFunctions.isBetween;
import static org.javamoney.moneta.function.MonetaryFunctions.isCurrency;
import static org.javamoney.moneta.function.MonetaryFunctions.isGreaterThan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

public class MonetaryFilterOperationsDemo {

    private static CurrencyUnit DOLLAR = Monetary.getCurrency(Locale.US);
    private static CurrencyUnit EURO = Monetary.getCurrency("EUR");

    public static void main(String[] args) {

        MonetaryAmount money = Money.of(BigDecimal.valueOf(100D), DOLLAR);
        MonetaryAmount min = Money.of(BigDecimal.valueOf(6D), DOLLAR);
        MonetaryAmount max = Money.of(BigDecimal.valueOf(100D), DOLLAR);

        List<MonetaryAmount> moneys = monies();
        List<MonetaryAmount> justDollar = moneys.stream()
                                            .filter(isCurrency(DOLLAR))
                                            .collect(toList());
        List<MonetaryAmount> dollarsGreaterThan100 = moneys.stream()
                                    .filter(isCurrency(DOLLAR).and(isGreaterThan(money)))
                                    .collect(toList());
        List<MonetaryAmount>  dollarsGreaterThan100Distinct = 
                moneys.stream()
                    .distinct()
                    .filter(
                        isCurrency(DOLLAR).and(isGreaterThan(money))
                    )
                    .collect(toList());
        List<MonetaryAmount> between = moneys.stream()
                                        .filter(isCurrency(DOLLAR).and(isBetween(min, max)))
                                        .collect(toList());
        System.out.println("");
        System.out.println(justDollar);
        System.out.println("Dollars greater than 100:");
        System.out.println(dollarsGreaterThan100);
        System.out.println("Distinct dollar greater than 100:");
        System.out.println(dollarsGreaterThan100Distinct);
        System.out.println("Dollars between 6 and 100:");
        System.out.println(between);

    }

    private static List<MonetaryAmount> monies() {
        List<MonetaryAmount> monies = new ArrayList<>();
        monies.add(Money.of(120, DOLLAR));
        monies.add(Money.of(50, DOLLAR));
        monies.add(Money.of(80, DOLLAR));
        monies.add(Money.of(99, DOLLAR));
        monies.add(Money.of(120, DOLLAR));

        monies.add(Money.of(120, EURO));
        monies.add(Money.of(50, EURO));
        monies.add(Money.of(80, EURO));
        monies.add(Money.of(99, EURO));
        monies.add(Money.of(120, EURO));

        return monies;
    }
}
