package com.farhad.example.decimals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BigDecimalDivision {
    
    public static void main(String[] args) {
        BigDecimal n = new BigDecimal("1");
        BigDecimal big_3 = new BigDecimal("3");

        try {
            log.info("{}", n.divide(big_3));
        } catch (Exception e) {
            log.error("{} : {}", e.getClass().getName(), e.getMessage());         
        }

        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        log.info("{}", n.divide(big_3, mc));
    }
}
