package com.farhad.example.codekata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class RecursionPrimeFactors {
    
    public static List<Integer> factorsOf(int n) {
        return factorsOf(n, 2, new ArrayList<Integer>());
    }

    private static List<Integer> factorsOf(int n, int d, ArrayList<Integer> factors) {
        if ( n > 1 ) {
            if(n % d == 0) {
                factors.add(d);
                factorsOf(n/d, d, factors);
            } else {
                factorsOf(n, d+1, factors);
            }
        } 
        return factors;
    }
    
}
