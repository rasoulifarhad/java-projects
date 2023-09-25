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
        // initialize array to true.
        for (int i = 2; i < isCrossed.length; i++) {
            isCrossed[i] = false;
        }
    }

    private static void sieve() {
        int maxPrimeFactor =calcMaxPrimeFactor();
        for (int i = 2; i < maxPrimeFactor; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);   
            }
        }
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < isCrossed.length; multiple += i) {
            isCrossed[multiple] = true; 
        }
    }

    private static int calcMaxPrimeFactor() {
        double maxPrimeFactor = Math.sqrt(isCrossed.length) + 1;
        return (int) maxPrimeFactor;
    }
    private static boolean isCrossed(int i) {
        return isCrossed[i];
    }


    private static boolean notCrossed(int i) {
        return isCrossed(i) == false;
    }
    private static void loadPrimes() {
        // how many primes are there?
        int count = 0;
        for (int i = 2; i < isCrossed.length; i++) {
            if (notCrossed(i)) {
                count++; // bump count.
            }
        }
        result = new int[count];
        // move the primes into the result
        for (int i = 2, j = 0; i < isCrossed.length; i++) {
            if (notCrossed(i)) {// if prime
                result[j++] = i;
            }
        }
    }
}