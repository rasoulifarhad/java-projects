package com.farhad.example.functional;

import static com.farhad.example.functional.SomeFunctionalDemo.curriedConverter;

import java.util.function.DoubleUnaryOperator;

import org.junit.jupiter.api.Test;

public class SomeFunctionalDemoTest {

    @Test
    void testCurriedConverter() {

        DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator conbertKMtoMIL = curriedConverter(0.6214, 0);

        System.out.println(convertCtoF.applyAsDouble(30));
        System.out.println(convertUSDtoGBP.applyAsDouble(10));
        System.out.println(conbertKMtoMIL.applyAsDouble(10));
    }
}
