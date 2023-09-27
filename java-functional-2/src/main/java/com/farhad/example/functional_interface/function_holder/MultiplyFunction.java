package com.farhad.example.functional_interface.function_holder;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public enum MultiplyFunction  implements BinaryOperator<Integer> {
    DIRECTMUL {

        @Override
        public Integer apply(Integer a, Integer b) {
            return a * b;
        }

    },
    OTHERMUL{

        @Override
        public Integer apply(Integer a, Integer b) {
            return otherMul(a, b);
        }

    };

    private static Integer otherMul(Integer a, Integer b) {
        return a * b;
    }
    
    public static void main(String[] args) {
        Function<Integer, Integer> plus1 = e -> e + 1;
        System.out.println(MultiplyFunction.DIRECTMUL.andThen(plus1).apply(3, 4));
    }
}
