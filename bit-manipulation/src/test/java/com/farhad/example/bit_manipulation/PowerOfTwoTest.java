package com.farhad.example.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PowerOfTwoTest {

    private PowerOfTwo powerOfTwo;

    @BeforeEach
    public void setup() {
        powerOfTwo = new PowerOfTwo();
    }

    @Test
    void testIsPowerOf2() {
        assertTrue(powerOfTwo.isPowerOf2(8));
        assertFalse(powerOfTwo.isPowerOf2(10));
    }

    @Test
    void testIsPowerOf2BW() {
        assertTrue(powerOfTwo.isPowerOf2BW(8));
        assertFalse(powerOfTwo.isPowerOf2BW(10));
    }
}
