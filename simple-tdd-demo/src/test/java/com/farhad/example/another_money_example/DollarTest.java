package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DollarTest {


    @Test 
    public void fiveDollarsHasValue5() {
        Dollar subject = new Dollar(5);
        int actual = subject.value();

        assertEquals(5, actual);
    }

    @Test 
    public void savenDollarsHasValue() {
        Dollar subject = new Dollar(7);
        int actual = subject.value();

        assertEquals(7, actual);
    }

    @Test 
    public void nineDollarsHasValue() {
        Dollar subject = new Dollar(9);
        int actual = subject.value();

        assertEquals(9, actual);
    }

}
