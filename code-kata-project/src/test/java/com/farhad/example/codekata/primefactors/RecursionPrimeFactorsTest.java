package com.farhad.example.codekata.primefactors;

import static com.farhad.example.codekata.primefactors.RecursionPrimeFactors.factorsOf;

import org.junit.jupiter.api.Test;

public class RecursionPrimeFactorsTest {
   
    @Test
    void testGenerate() {
        System.out.println(factorsOf(9));
        System.out.println(factorsOf(2222));
    }
    
}