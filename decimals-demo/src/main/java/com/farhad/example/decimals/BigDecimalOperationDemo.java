package com.farhad.example.decimals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BigDecimalOperationDemo {
    
    public static void main(String[] args) {
        
        BigDecimal n1 = new BigDecimal("1000.123482248908085303458975309348");
        BigDecimal n2 = new BigDecimal("2000.122837345398340801010291390210252");

        log.info("n1      = {}", n1);
        log.info("n2      = {}", n2);
        BigDecimal n1PlusN2 = n1.add(n2);
        log.info("n1 + n2 = {}", n1PlusN2);
        BigDecimal n1MultiplyN2 = n1.multiply(n2);
        log.info("n1 * n2 = {}", n1MultiplyN2);
        BigDecimal n1DivideN2 = n1.divide(n2, RoundingMode.HALF_UP);
        log.info("n1 / n2 = {}", n1DivideN2);
    }
}
