package com.farhad.example.decimals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BigDecimalRoundingDemo {
    public static void main(String[] args) {
        
        BigDecimal n11 = new BigDecimal("0.11");
        BigDecimal n15 = new BigDecimal("0.15");
        BigDecimal n19 = new BigDecimal("0.19");

        BigDecimal neg_n11 = new BigDecimal("-0.11");
        BigDecimal neg_n15 = new BigDecimal("-0.15");
        BigDecimal neg_n19 = new BigDecimal("-0.19");

        MathContext mc_CEILING = new MathContext(1, RoundingMode.CEILING);
        MathContext mc_FLOOR = new MathContext(1, RoundingMode.FLOOR);
        MathContext mc_UP = new MathContext(1, RoundingMode.UP);
        MathContext mc_DOWN = new MathContext(1, RoundingMode.DOWN);
        MathContext mc_HALF_UP = new MathContext(1, RoundingMode.HALF_UP);
        MathContext mc_HALF_EVEN = new MathContext(1, RoundingMode.HALF_EVEN);
        MathContext mc_HALF_DOWN = new MathContext(1, RoundingMode.HALF_DOWN);
        MathContext mc_UNNECESSARY = new MathContext(1, RoundingMode.UNNECESSARY);

        roundAndLog(mc_CEILING, n11, n15, n19, neg_n11, neg_n15, neg_n19);
        roundAndLog(mc_FLOOR, n11, n15, n19, neg_n11, neg_n15, neg_n19);
        roundAndLog(mc_UP, n11, n15, n19, neg_n11, neg_n15, neg_n19);
        roundAndLog(mc_DOWN, n11, n15, n19, neg_n11, neg_n15, neg_n19);
        roundAndLog(mc_HALF_UP, n11, n15, n19, neg_n11, neg_n15, neg_n19);
        roundAndLog(mc_HALF_EVEN, n11, n15, n19, neg_n11, neg_n15, neg_n19);
        roundAndLog(mc_HALF_DOWN, n11, n15, n19, neg_n11, neg_n15, neg_n19);

        try{
            roundAndLog(mc_UNNECESSARY, n11);       
        } catch (Exception e) {
            log.error("{} : {}", e.getClass().getName(), e.getMessage());
        }

        try{
            roundAndLog(mc_UNNECESSARY, n19);       
        } catch (Exception e) {
            log.error("{} : {}", e.getClass().getName(), e.getMessage());
        }

    }

    private static void roundAndLog(MathContext mc, BigDecimal... numbers) {
        log.info("");
        log.info("================================");
        log.info("= RoundingMode: `{}` ",mc.getRoundingMode().toString());
        log.info("================================");
        Stream.of(numbers)
            .forEach(number -> log.info("{} -> (RoundingMode.{}) -> {}", number, mc.getRoundingMode().toString(), number.round(mc)));
    }
}