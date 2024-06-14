package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DollarTest {


    @ParameterizedTest
    @ValueSource(ints = {5, 7, 9})
    public void savenDollarsHasValue(int input) {
        Dollar subject = new Dollar(input);
        int actual = subject.value();

        assertEquals(input, actual);
    }

    @Test
    public void savenDollarsHasValue() {
        int value = 1 + new Random().nextInt(20);
        Dollar subject = new Dollar(value);
        int actual = subject.value();

        assertEquals(value, actual);
    }

}
