package com.farhad.example.money;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FormatDemo {
    public static void main(String[] args) {
        
        CurrencyUnit dollar = Monetary.getCurrency(Locale.US);
        MonetaryAmount monetaryAmount = Money.of(1202.12D, dollar);
        MonetaryAmountFormat germanFormat = MonetaryFormats.getAmountFormat(Locale.GERMANY);
        MonetaryAmountFormat usFormat = MonetaryFormats.getAmountFormat(Locale.US);
        MonetaryAmountFormat customFormat = MonetaryFormats.getAmountFormat(
            AmountFormatQueryBuilder.of(Locale.US)
                        .set(CurrencyStyle.SYMBOL)
                        .build());
        MonetaryAmountFormat customFormat2 = MonetaryFormats.getAmountFormat(
            AmountFormatQueryBuilder.of(Locale.US).set(CurrencyStyle.NAME).build());

        log.info("{}",germanFormat.format(monetaryAmount));
        log.info("{}", usFormat.format(monetaryAmount));
        log.info("{}", customFormat.format(monetaryAmount));
        log.info("{}", customFormat2.format(monetaryAmount));
    }

}
