package com.farhad.example.design_principles02.ppp.exercise_2_srp.library;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void testEqualityShouldPassWithEqualValues() {
        Assertions.assertThat(new Money(0)).isEqualTo(new Money(0));
    }

    @Test 
    public void testEqualityShouldFailWithUnequalValues() {
        assertFalse(new Money(0).equals(new Money(1)));
    }
}
