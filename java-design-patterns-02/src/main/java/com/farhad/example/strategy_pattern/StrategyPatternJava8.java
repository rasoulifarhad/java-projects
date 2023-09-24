package com.farhad.example.strategy_pattern;

import java.util.function.Predicate;

public class StrategyPatternJava8 {
    
    public static class Strategy {

        static int totalBy(Predicate<Integer> predicate, int... numbers) {
            int total =0;
            for (int number : numbers) {
                if(predicate.test(number)) {
                    total += number;
                }
            }
            return total;
        }
    }
}
