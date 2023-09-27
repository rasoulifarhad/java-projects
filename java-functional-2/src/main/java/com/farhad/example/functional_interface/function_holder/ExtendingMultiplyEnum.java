package com.farhad.example.functional_interface.function_holder;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public enum ExtendingMultiplyEnum implements BinaryOperator<Integer> {
    
    DIRECTMUL((a, b) -> a * b),
    OTHERMUL((a, b) -> otherMul(a, b));

    private BinaryOperator<Integer> multiplier;

    ExtendingMultiplyEnum(BinaryOperator<Integer> multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public Integer apply(Integer a, Integer b) {
        return multiplier.apply(a, b);
    }

    private static Integer otherMul(Integer a, Integer b ) {
        return a * b;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> plus1 = e -> e + 1;
        System.out.println(DIRECTMUL.andThen(plus1).apply(3, 4));
    }
}
