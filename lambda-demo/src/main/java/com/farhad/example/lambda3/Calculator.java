package com.farhad.example.lambda3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calculator {
    
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int biOperation(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        IntegerMath add = (a, b) -> a + b;
        IntegerMath subtract = (a, b) -> a - b;

        log.info("10 + 2 = {}", calc.biOperation(40, 2, add));
        log.info("10 + 2 = {}", calc.biOperation(40, 2, subtract));
        
    }
}
