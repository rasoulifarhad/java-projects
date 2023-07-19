package com.farhad.example.functional;

import java.util.function.DoubleUnaryOperator;

public class SomeFunctionalDemo {

    public static DoubleUnaryOperator curriedConverter(double factor, double baseLine) {
        return (double x) -> x * factor + baseLine;
    }

    
}
