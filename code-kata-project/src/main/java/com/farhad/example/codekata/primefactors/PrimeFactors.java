package com.farhad.example.codekata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
      
    public static List<Integer> factorsOf(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int condidate = 2; n > 1; condidate++) {
            for (; n % condidate == 0; n /= condidate) {
                factors.add(condidate);
            }
        }
        return factors;
    }
}   
