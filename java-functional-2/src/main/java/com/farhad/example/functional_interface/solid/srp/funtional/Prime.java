package com.farhad.example.functional_interface.solid.srp.funtional;

import java.util.stream.IntStream;

public class Prime {

    public long countPrimes(int upTo) {
        return IntStream.range(1, upTo)
            .filter(this::isPrime)
            .count();

            
    }

    public boolean isPrime(int number) {
        return IntStream.range(2, number)
            .allMatch(value -> (number % value) != 0);
    }

}
