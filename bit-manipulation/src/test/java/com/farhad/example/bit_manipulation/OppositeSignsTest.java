package com.farhad.example.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OppositeSignsTest {

    private OppositeSigns oppositeSigns;

    @BeforeEach
    public void setup() {
        oppositeSigns = new OppositeSigns();
    }

    @Test
    void testAreOfOppositeSigns() {
        assertTrue(oppositeSigns.areOfOppositeSigns(4, -100));
        assertTrue(oppositeSigns.areOfOppositeSigns(4, -100));
    }

    @Test
    void testAreOfOppositeSignsBitwise() {
        assertTrue(oppositeSigns.areOfOppositeSignsBitwise(4, -100));
        assertTrue(oppositeSigns.areOfOppositeSignsBitwise(4, -100));
    }
}
