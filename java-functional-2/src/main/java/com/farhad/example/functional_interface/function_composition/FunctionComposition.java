package com.farhad.example.functional_interface.function_composition;

import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> plus1 = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;
        Function<Integer, Integer> composition = plus1.andThen(doubleIt);
        Function<Integer, Integer> compose = plus1.compose(doubleIt);
        System.out.println(composition.apply(5));
        System.out.println(compose.apply(5));
    }
}
