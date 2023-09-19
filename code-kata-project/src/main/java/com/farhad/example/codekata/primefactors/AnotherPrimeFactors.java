package com.farhad.example.codekata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class AnotherPrimeFactors {
    
    public static List<Integer> factorsOf(int n) {
        return factorsOf(n, 2, new ArrayList<Integer>());
    }

    private static List<Integer> factorsOf(int n, int d, ArrayList<Integer> factors) {
        while (true) {
            if( n > 1 ) {
                if( n % d == 0) {
                    factors.add(d);
                    n /=d;
                } else {
                    d++;
                }
            } else {
                return factors;
            }
        }
    }

    private static List<Integer> anotherFactorsOf(int n, int d, ArrayList<Integer> factors) {
        while (true) {
            boolean factorsRemain = n > 1;
            boolean currentDivisorIsFactor = n % d == 0;        
            if(factorsRemain) {
                if(currentDivisorIsFactor) {
                    factors.add(d);
                    n /=d;
                } else {
                    d++;
                }
            } else {
                return factors;
            }
        }
    }

    private static List<Integer> anotherFactorsOf02(int n, int d, ArrayList<Integer> factors) {
        while (true) {
            boolean factorsRemain = n > 1;
            boolean currentDivisorIsFactor = n % d == 0;        
            if (factorsRemain && currentDivisorIsFactor) {
                factors.add(d);
                n /= d;
            }
            if (factorsRemain && !currentDivisorIsFactor) {
                d++;
            }
            if (!factorsRemain) {
                return factors;
            }
        }
    }

    private static List<Integer> anotherFactorsOf03(int n, int d, ArrayList<Integer> factors) {
        while (true) {
            boolean factorsRemain = n > 1;
            boolean currentDivisorIsFactor = n % d == 0;        
            boolean factorOutCurrentDivisor = factorsRemain && currentDivisorIsFactor;
            boolean tryNextDivisor = factorsRemain && !currentDivisorIsFactor;
            boolean allDone = !factorsRemain;
            if (factorOutCurrentDivisor) {
                factors.add(d);
                n /= d;
            }
            if (tryNextDivisor) {
                d++;
            }
            if (allDone) {
                return factors;
            }
        }
    }

}
