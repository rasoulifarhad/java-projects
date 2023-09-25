package com.farhad.example.generate_primes.refactored;

public class PrimeGenerator {
    /**
     * @param maxValue is the generation limit.
     */

    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        // initialize array to true.
        for (int i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }

    private static void crossOutMultiples() {
        int maxPrimeFactor = determineIterationLimit();
        for (int i = 2; i < maxPrimeFactor; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);   
            }
        }
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i) {
            crossedOut[multiple] = true; 
        }
    }

    private static int determineIterationLimit() {
        double iterationLimit = Math.sqrt(crossedOut.length) ;
        return (int) iterationLimit;
    }
    private static boolean isCrossed(int i) {
        return crossedOut[i];
    }


    private static boolean notCrossed(int i) {
        return isCrossed(i) == false;
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int i = 2, j = 0; i < crossedOut.length; i++) {
            if (notCrossed(i)) {// if prime
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++) {
            if (notCrossed(i)) {
                count++; // bump count.
            }
        }
        return count;
    }
}