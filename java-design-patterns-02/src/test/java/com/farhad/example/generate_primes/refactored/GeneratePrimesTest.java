package com.farhad.example.generate_primes.refactored;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GeneratePrimesTest {

    @Test
    public void testPrimes() {
        int[] nullArray = PrimeGenerator.generatePrimes(0);
        assertEquals(nullArray.length, 0);
        int[] minArray = PrimeGenerator.generatePrimes(2);
        assertEquals(minArray.length, 1);
        assertEquals(minArray[0], 2);
        int[] threeArray = PrimeGenerator.generatePrimes(3);
        assertEquals(threeArray.length, 2);
        assertEquals(threeArray[0], 2);
        assertEquals(threeArray[1], 3);
        int[] centArray = PrimeGenerator.generatePrimes(100);
        assertEquals(centArray.length, 25);
        assertEquals(centArray[24], 97);
    }

    @Test
    public void testExhaustive() {
        for (int i = 2; i < 500; i++)
            verifyPrimeList(PrimeGenerator.generatePrimes(i));
    }

    private void verifyPrimeList(int[] list) {
        for (int i = 0; i < list.length; i++)
            verifyPrime(list[i]);
    }

    private void verifyPrime(int n) {
        for (int factor = 2; factor < n; factor++)
            assert (n % factor != 0);
    }
}
