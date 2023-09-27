package com.farhad.example.functional_interface.stream;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Example2 {
    
    public static void main(String[] args) {
        IntStream stream = IntStream.of(7, 8, 9, 10, 11, 12);
        IntPredicate isEven = e -> e % 2 == 0;
        IntUnaryOperator square = e ->  e * e;
        stream.filter(isEven)
            .map(square)
            .forEach(System.out::println);
    }

}
