package com.farhad.example.decimals;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FloadAndBigDecimalDemo {
    
    public static void main(String[] args) {
        
        float f = 0.1f;
        BigDecimal b = new BigDecimal(f);
        log.info("");
        log.info("f: float(32 bit)");
        log.info("b: big decimal of f");
        print(f, b);
        print(f * 1000, b.multiply(new BigDecimal(1000)));
        print(f * 100000, b.multiply(new BigDecimal(100000)));
        print(f * 10000000, b.multiply(new BigDecimal(10000000)));
        print(f * 1000000000, b.multiply(new BigDecimal(1000000000)));

        float f1 = 0.1f;
        BigDecimal b1 = new BigDecimal("0.1");
        log.info("");
        log.info("f: float(32 bit)");
        log.info("b: big decimal of 0.1");
        print(f1, b1);
        print(f1 * 1000, b1.multiply(new BigDecimal(1000)));
        print(f1 * 100000, b1.multiply(new BigDecimal(100000)));
        print(f1 * 10000000, b1.multiply(new BigDecimal(10000000)));
        print(f1 * 1000000000, b1.multiply(new BigDecimal(1000000000)));
    }

    private static void print(float f, BigDecimal b) {
        log.info("");
        log.info("=============================");
        log.info("f     = {}", f);
        log.info("b     = {}", b);
        log.info("b - f = {}", b.subtract(new BigDecimal(Float.toString(f))));

    }
}
