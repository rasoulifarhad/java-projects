package com.farhad.example.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.bit_manipulation.SwapValues.Pair;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class SwapValuesTest {

    private SwapValues swapValues;

    @BeforeEach
    public void setup() {
        swapValues = new SwapValues();
    }

    @Test
    void testSwapValues() {
        TestData testData = get();
        assertEquals(swapValues.swapValues(testData.origin), testData.expected);
    }

    @Test
    void testSwapValuesBW() {
        TestData testData = get();
        assertEquals(swapValues.swapValuesBW(testData.origin), testData.expected);
    }

    private TestData get() {
        return new TestData(new Pair(100, 200), new Pair(200, 100));
    }

    @RequiredArgsConstructor
    @Getter
    static class TestData {
        final Pair origin;
        final Pair expected;
    }
}
