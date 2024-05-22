package com.farhad.example.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BitManipulationBasicsTest {

    private BitManipulationBasics bm;

    @BeforeEach
    public void setup() {
        bm = new BitManipulationBasics();
    }

    @Test
    void testDivideBy2() {
        assertEquals(bm.divideBy2(8), 4);
    }

    @Test
    void testMultiplyBy2() {
        assertEquals(bm.multiplyBy2(4), 8);
    }
}
