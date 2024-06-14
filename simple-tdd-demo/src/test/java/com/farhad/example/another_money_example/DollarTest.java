package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DollarTest {



    @Test 
    public void fiveDollarsHasValue5() {
        Dollar subject = new Dollar(5);
        int actual = subject.value();

        assertEquals(5, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 7, 9})
    public void savenDollarsHasValue(int input) {
        Dollar subject = new Dollar(input);
        int actual = subject.value();

        assertEquals(input, actual);
    }

    @Test 
    public void nineDollarsHasValue() {
        Dollar subject = new Dollar(9);
        int actual = subject.value();

        assertEquals(9, actual);
    }

}
