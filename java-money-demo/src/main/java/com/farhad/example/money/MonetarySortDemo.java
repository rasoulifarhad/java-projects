package com.farhad.example.money;

import static java.util.stream.Collectors.toList;
import static org.javamoney.moneta.function.MonetaryFunctions.sortCurrencyUnit;
import static org.javamoney.moneta.function.MonetaryFunctions.sortNumber;
import static org.javamoney.moneta.function.MonetaryFunctions.sortNumberDesc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonetarySortDemo {
 
    public static void main(String[] args) {
        List<MonetaryAmount> orderCurrency =  getMoneys().stream()
                                                .sorted(sortCurrencyUnit())
                                                .collect(toList());
        log.info("");
        log.info("{}", orderCurrency);
        log.info("");
        List<MonetaryAmount> sorted = getMoneys().stream()
                                    .sorted(sortCurrencyUnit().thenComparing(sortNumber()))
                                    .collect(toList());
                        
        log.info("");
        log.info("{}", sorted);
        log.info("");

        sorted = getMoneys().stream()
                    .sorted(sortCurrencyUnit().thenComparing(sortNumberDesc()))
                    .collect(toList());

        log.info("");
        log.info("{}", sorted);
        log.info("");
    }

    private static List<MonetaryAmount> getMoneys() {
        CurrencyUnit DOLLAR = Monetary.getCurrency(Locale.US);
        List<MonetaryAmount> monies = new ArrayList<>();

        monies.add(Money.of(120, DOLLAR));
        monies.add(Money.of(50, DOLLAR));
        monies.add(Money.of(80, DOLLAR));
        monies.add(Money.of(99, DOLLAR));
        monies.add(Money.of(120, DOLLAR));
        return monies;
    }

}
