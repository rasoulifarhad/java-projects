package com.farhad.example.money;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonetaryReduceDemo {
    
    public static void main(String[] args) {
        
        MonetaryAmount amount = getMoneys().stream().reduce(MonetaryFunctions.min()).get();
        log.info("Min: {}", amount);
        amount = getMoneys().stream().reduce(MonetaryFunctions.max()).get();
        log.info("Max: {}", amount);
        amount = getMoneys().stream().reduce(MonetaryFunctions.sum()).get();
        log.info("Sum: {}", amount);
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
