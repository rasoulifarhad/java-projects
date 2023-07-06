package com.farhad.example.money;

import static org.javamoney.moneta.function.MonetaryFunctions.groupByCurrencyUnit;
import static org.javamoney.moneta.function.MonetaryFunctions.groupBySummarizingMonetary;
import static org.javamoney.moneta.function.MonetaryFunctions.isCurrency;
import static org.javamoney.moneta.function.MonetaryFunctions.summarizingMonetary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.GroupMonetarySummaryStatistics;
import org.javamoney.moneta.function.MonetarySummaryStatistics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonetaryGroupOperationsDemo {

    private static CurrencyUnit DOLLAR = Monetary.getCurrency(Locale.US);
    private static CurrencyUnit EURO = Monetary.getCurrency("EUR");

    public static void main(String[] args) {
        Map<CurrencyUnit, List<MonetaryAmount>> groupByCurrency =  getMoneys().stream()
                                                                    .collect(groupByCurrencyUnit());
        log.info("{}", groupByCurrency);

        MonetarySummaryStatistics summary = getMoneys().stream()
                                                .filter(isCurrency(DOLLAR))
                                                .collect(summarizingMonetary(DOLLAR));
        log.info("{}", summary);

        GroupMonetarySummaryStatistics groupSummary = getMoneys().stream()
                                                        .filter(isCurrency(DOLLAR))
                                                        .collect(groupBySummarizingMonetary());
        log.info("{}", groupSummary);
    }

    private static List<MonetaryAmount> getMoneys() {
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
