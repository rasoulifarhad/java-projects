package com.farhad.example.functional_interface.solid.srp.oop;

public class Prime {

    public long countPrimes(int upTo) {
        long tally =0;
        for (int i = 1; i < upTo; i++) {
            if(isPrime(i)) {
                tally++;
            }
        }

        return tally;
    }

    public boolean isPrime(int number) {

        for (int j = 2; j < number; j++) {
            if(number % j == 0) {
                return false;
            }
        }
        return true;
    }

}
