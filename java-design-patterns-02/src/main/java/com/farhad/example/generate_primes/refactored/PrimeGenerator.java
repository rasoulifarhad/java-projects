package com.farhad.example.generate_primes.refactored;

public class PrimeGenerator {
    /**
     * @param maxValue is the generation limit.
     */

    private static boolean[] isCrossed;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            initializeArrayOfIntegers(maxValue);
            sieve();
            loadPrimes();
            return result;
        }
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        isCrossed = new boolean[maxValue + 1];
        isCrossed[0] = isCrossed[1] = false;
        // initialize array to true.
        for (int i = 2; i < isCrossed.length; i++) {
            isCrossed[i] = true;
        }
    }

    private static void sieve() {
        int i, j;
        for (i = 2; i < Math.sqrt(isCrossed.length) + 1; i++) {
            if (isCrossed(i)) {// if i is uncrossed, cross its multiples.

                for (j = 2 * i; j < isCrossed.length; j += i) {
                    isCrossed[j] = false; // multiple is not prime
                }
            }
        }
    }

    private static boolean isCrossed(int i) {
        return isCrossed[i];
    }

    private static void loadPrimes() {
        int i, j;
        // how many primes are there?
        int count = 0;
        for (i = 0; i < isCrossed.length; i++) {
            if (isCrossed[i]) {
                count++; // bump count.
            }
        }
        result = new int[count];
        // move the primes into the result
        for (i = 0, j = 0; i < isCrossed.length; i++) {
            if (isCrossed[i]) {// if prime
                result[j++] = i;
            }
        }
    }
}