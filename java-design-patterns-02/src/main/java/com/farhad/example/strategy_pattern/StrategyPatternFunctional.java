package com.farhad.example.strategy_pattern;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

public class StrategyPatternFunctional {
    
    public static BiFunction<Predicate<Integer>, Iterable<Integer>,Integer> totalBy =
            (selector, numbers) -> StreamSupport.stream(numbers.spliterator(), true)
                                                .filter(selector)
                                                .reduce(Integer::sum)
                                                .orElse(0);

}
