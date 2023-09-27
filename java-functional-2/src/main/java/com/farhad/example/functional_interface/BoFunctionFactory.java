package com.farhad.example.functional_interface;

import java.util.function.BinaryOperator;

public class BoFunctionFactory {
    
    public static BinaryOperator<Integer> getFunctiovAdd() {
        return (a, b) ->  a + b;
    }

    public static BinaryOperator<Integer> getFunctiovMul() {
        return (a, b) ->  a * b;
    }

    public static void main(String[] args) {
        BinaryOperator<Integer> mul = BoFunctionFactory.getFunctiovMul();
        System.out.println(mul.apply(1, 3));
    }
}
