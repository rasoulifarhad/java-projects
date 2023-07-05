package com.farhad.example.money;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrencyUnitDemo {
    
    public static void main(String[] args) {
      log.info("");
      CurrencyUnit real = Monetary.getCurrency("BRL");
      CurrencyUnit dollar = Monetary.getCurrency(Locale.US);
      
      log.info("{}", real);
      log.info("{}", dollar);
    }
}
