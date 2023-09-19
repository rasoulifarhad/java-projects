package com.farhad.example.codekata.primefactors;

import static com.farhad.example.codekata.primefactors.PrimeFactors.factorsOf;

import org.junit.jupiter.api.Test;

public class PrimeFactorsTest {
    
    @Test
    void testGenerate() {
        System.out.println(factorsOf(9));
        System.out.println(factorsOf(2222));
    }
}
