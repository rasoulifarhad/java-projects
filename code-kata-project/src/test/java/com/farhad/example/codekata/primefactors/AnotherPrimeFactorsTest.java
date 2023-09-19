package com.farhad.example.codekata.primefactors;

import static com.farhad.example.codekata.primefactors.AnotherPrimeFactors.anotherFactorsOf;
import static com.farhad.example.codekata.primefactors.AnotherPrimeFactors.anotherFactorsOf02;
import static com.farhad.example.codekata.primefactors.AnotherPrimeFactors.anotherFactorsOf03;
import static com.farhad.example.codekata.primefactors.AnotherPrimeFactors.anotherFactorsOfWithEnumAndSwitch;
import static com.farhad.example.codekata.primefactors.AnotherPrimeFactors.anotherFactorsOfWithEnumAndSwitch02;
import static com.farhad.example.codekata.primefactors.AnotherPrimeFactors.anotherFactorsOfWithEnumAndSwitch03;
import static com.farhad.example.codekata.primefactors.AnotherPrimeFactors.factorsOf;

import org.junit.jupiter.api.Test;

public class AnotherPrimeFactorsTest {

    @Test
    void testFactorsOf() {
        System.out.println(factorsOf(9));
        System.out.println(factorsOf(2222));
    }

    @Test
    void testAnotherFactorsOf() {
        System.out.println(anotherFactorsOf(9));
        System.out.println(anotherFactorsOf(2222));
    }

    @Test
    void testAnotherFactorsOf02() {
        System.out.println(anotherFactorsOf02(9));
        System.out.println(anotherFactorsOf02(2222));
    }

    @Test
    void testAnotherFactorsOf03() {
        System.out.println(anotherFactorsOf03(9));
        System.out.println(anotherFactorsOf03(2222));
    }

    @Test
    void testAnotherFactorsOfWithEnumAndSwitch() {
        System.out.println(anotherFactorsOfWithEnumAndSwitch(9));
        System.out.println(anotherFactorsOfWithEnumAndSwitch(2222));
    }

    @Test
    void testAnotherFactorsOfWithEnumAndSwitch02() {
        System.out.println(anotherFactorsOfWithEnumAndSwitch02(9));
        System.out.println(anotherFactorsOfWithEnumAndSwitch02(2222));
    }

    @Test
    void testAnotherFactorsOfWithEnumAndSwitch03() {
        System.out.println(anotherFactorsOfWithEnumAndSwitch03(9));
        System.out.println(anotherFactorsOfWithEnumAndSwitch03(2222));
    }

}
