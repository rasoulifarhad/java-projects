package com.farhad.example.functional_interface.solid.srp.raw;

public class Prime {

    public long countPrimes(int upTo) {
        long tally =0;
        for (int i = 1; i < upTo; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) {
                tally++;
            }
        }

        return tally;
    }
}
