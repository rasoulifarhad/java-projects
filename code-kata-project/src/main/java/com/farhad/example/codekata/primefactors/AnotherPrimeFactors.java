package com.farhad.example.codekata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class AnotherPrimeFactors {
    
    public static List<Integer> factorsOf(int n) {
        return factorsOf(n, 2, new ArrayList<Integer>());
    }

    public static List<Integer> anotherFactorsOf(int n) {
        return anotherFactorsOf(n, 2, new ArrayList<Integer>());
    }

    public static List<Integer> anotherFactorsOf02(int n) {
        return anotherFactorsOf02(n, 2, new ArrayList<Integer>());
    }

    public static List<Integer> anotherFactorsOf03(int n) {
        return anotherFactorsOf03(n, 2, new ArrayList<Integer>());
    }

    // make this more interesting by using an enum and a switch.
    public static List<Integer> anotherFactorsOfWithEnumAndSwitch(int n) {
        return anotherFactorsOfWithEnumAndSwitch(n, 2, new ArrayList<Integer>());
    }

    // Now let’s move the determination of the next state into each case.
    public static List<Integer> anotherFactorsOfWithEnumAndSwitch02(int n) {
        return anotherFactorsOfWithEnumAndSwitch02(n, 2, new ArrayList<Integer>());
    }

    public static List<Integer> anotherFactorsOfWithEnumAndSwitch03(int n) {
        return anotherFactorsOfWithEnumAndSwitch03(n, 2, new ArrayList<Integer>());
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

    private enum State {Starting, Factoring, Searching, Done}

    private static List<Integer> anotherFactorsOfWithEnumAndSwitch(int n, int d, ArrayList<Integer> factors) {
        State state = State.Starting;
        while (true) {
            boolean factorsRemain = n > 1;
            boolean currentDivisorIsFactor = n % d == 0;        
            if(factorsRemain && currentDivisorIsFactor) {
                state = State.Factoring;
            }
            if(factorsRemain && !currentDivisorIsFactor) {
                state = State.Searching;
            }
            if(!factorsRemain) {
                state = State.Done;
            }
            switch (state) {
                case Factoring:
                    factors.add(d);
                    n /= d;
                    break;
                case Searching:
                    d++;
                    break;
                case Done:
                    return factors;
                default:
                    break;
            }            
        }

    }

    private static List<Integer> anotherFactorsOfWithEnumAndSwitch02(int n, int d, ArrayList<Integer> factors) {
        State state = State.Starting;
        while (true) {
            switch (state) {
                case Starting:
                    if (n == 1 ) {
                        state = State.Done;
                    } else if (n % d == 0) {
                        state = State.Factoring;
                    } else {
                        state = State.Searching;
                    }
                    break;
                case Factoring:
                    factors.add(d);
                    n /= d;
                    if (n == 1) {
                        state = State.Done;
                    } else if (n % d != 0) {
                        state = State.Searching;
                    }
                    break;
                case Searching:
                    d++;
                    if(n == 1) {
                        state = State.Done;
                    } else if (n % d == 0) {
                        state = State.Factoring;
                    } 
                    break;
                case Done:
                    return factors;
            }            
        }

    }

    private static List<Integer> anotherFactorsOfWithEnumAndSwitch03(int n, int d, ArrayList<Integer> factors) {
        State state = State.Starting;
        while (true) {
            switch (state) {
                case Starting:
                    break;
                case Factoring:
                    factors.add(d);
                    n /= d;
                    break;
                case Searching:
                    d++;
                    break;
                case Done:
                    return factors;
            } 
            
            if(n == 1){
                state = State.Done;
            } else if (n % d == 0) {
                state = State.Factoring;
            } else {
                state = State.Searching;
            }
        }

    }

}
