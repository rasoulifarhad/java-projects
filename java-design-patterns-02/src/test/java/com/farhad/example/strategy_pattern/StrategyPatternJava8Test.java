package com.farhad.example.strategy_pattern;

import static com.farhad.example.strategy_pattern.StrategyPatternJava8.Strategy.totalBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StrategyPatternJava8Test {

    @Test
    void any() {
        int total = totalBy(n -> true, 1, 2, 3, 4, 5);
        assertThat(total).isEqualTo(15);
    }

    @Test
    void even() {
        int total = totalBy(n -> n%2 == 0, 1, 2, 3, 4, 5);
        assertThat(total).isEqualTo(6);
    }

    @Test
    void odd() {
        int total = totalBy(n -> n%2 != 0, 1, 2, 3, 4, 5);
        assertThat(total).isEqualTo(9);
    }

    @Test
    void none() {
        int total = totalBy(n -> false, 1, 2, 3, 4, 5);
        assertThat(total).isEqualTo(0);
    }

}
