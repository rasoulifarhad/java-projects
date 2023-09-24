package com.farhad.example.strategy_pattern;

import static com.farhad.example.strategy_pattern.StrategyPatternFunctional.totalBy;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StrategyPatternFunctionalTest {

    @Test
    void any() {
        int total = totalBy.apply(n -> true, asList(1, 2, 3, 4, 5));
        assertThat(total).isEqualTo(15);
    }

    @Test void even() {
        int total = totalBy.apply(n -> n % 2 == 0, asList(1, 2, 3, 4, 5));
        assertThat(total).isEqualTo(6);
      }
    
      @Test void odd() {
        int total = totalBy.apply(n -> n % 2 != 0, asList(1, 2, 3, 4, 5));
        assertThat(total).isEqualTo(9);
      }
    
      @Test void none() {
        int total = totalBy.apply(n -> false, asList(1, 2, 3, 4, 5));
        assertThat(total).isEqualTo(0);
      }    
}
