package com.farhad.example.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountBitsTest {

    private CountBits countBits;

    @BeforeEach
    public void setup() {
        countBits = new CountBits();
    }

    @Test
    void testCountBitsBW() {
        assertEquals(countBits.countBitsLib(3), 2);
    }

    @Test
    void testCountBitsBWBest() {
        assertEquals(countBits.countBitsBWBest(3), 2);
    }

    @Test
    void testCountBitsLib() {
        assertEquals(countBits.countBitsBW(3), 2);
    }
}
