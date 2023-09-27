package com.farhad.example.functional_interface.stream;

import java.util.stream.IntStream;

public class Example1 {
    public static void main(String[] args) {
        IntStream stream = IntStream.of(7, 8, 9, 10, 11, 12);
        stream.filter(e -> e % 2 == 0)
            .map(e -> e * e )
            .forEach(e -> System.out.println(e));
    }
}
