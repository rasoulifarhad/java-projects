package com.farhad.example.generate_primes.refactored;

public class PrimeGenerator {
    /**
     * @param maxValue is the generation limit.
     */

    private static int s;
    private static boolean[] f;
    private static int[] primes;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            initializeSieve(maxValue);
            sieve();
            loadPrimes();
            return primes;
        }
    }

    private static void initializeSieve(int maxValue) {
        int s = maxValue + 1; // size of array
        boolean[] f = new boolean[s];
        int i;
        // initialize array to true.
        for (i = 0; i < s; i++) {
            f[i] = true;
        }
        // get rid of known non-primes
        f[0] = f[1] = false;

    }

    private static void sieve() {
        int i, j;
        for (i = 2; i < Math.sqrt(s) + 1; i++) {
            if (f[i]) {// if i is uncrossed, cross its multiples.

                for (j = 2 * i; j < s; j += i) {
                    f[j] = false; // multiple is not prime
                }
            }
        }
    }

    private static void loadPrimes() {
        int i, j;
        // how many primes are there?
        int count = 0;
        for (i = 0; i < s; i++) {
            if (f[i]) {
                count++; // bump count.
            }
        }
        int[] primes = new int[count];
        // move the primes into the result
        for (i = 0, j = 0; i < s; i++) {
            if (f[i]) {// if prime
                primes[j++] = i;
            }
        }
    }
}