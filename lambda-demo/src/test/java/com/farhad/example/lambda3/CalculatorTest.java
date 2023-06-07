package com.farhad.example.lambda3;

import org.junit.jupiter.api.Test;

import com.farhad.example.lambda3.Calculator.IntegerMath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorTest {
    @Test
    void testBiOperation() {
        Calculator calc = new Calculator();
        IntegerMath add = (a, b) -> a + b;
        IntegerMath subtract = (a, b) -> a - b;

        log.info("10 + 2 = {}", calc.biOperation(40, 2, add));
        log.info("10 + 2 = {}", calc.biOperation(40, 2, subtract));    }
}
