package com.farhad.example.monostate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurnstileTest {

    @BeforeEach
    void setup() {
        Turnstile t = new Turnstile();
        t.reset();
    }

    @Test
    void testInit() {
        Turnstile t = new Turnstile();
        assertTrue(t.locked());
        assertTrue(!t.alarm());
    }

    @Test
    void testCoin() {
        Turnstile t = new Turnstile();
        t.coin();
        Turnstile t1 = new Turnstile();
        assertTrue(!t1.locked());
        assertTrue(!t1.alarm());
        assertEquals(1, t1.coins());

    }

    @Test
    void testCoinAndPass() {
        Turnstile t = new Turnstile();
        t.reset();
        t.coin();
        t.pass();

        Turnstile t1 = new Turnstile();
        assertTrue(t1.locked());
        assertEquals(1, t1.coins());
        assertTrue(!t1.alarm());
    }

    @Test
    void testTwoCoins() {
        Turnstile t = new Turnstile();
        t.coin();
        t.coin();

        Turnstile t1 = new Turnstile();
        assertTrue(!t1.locked());
        assertEquals(1, t1.coins());
        assertEquals(1, t1.refunds());
        assertTrue(!t1.alarm());
    }

    @Test
    void testPass() {
        Turnstile t = new Turnstile();
        t.pass();
        Turnstile t1 = new Turnstile();
        assertTrue(t1.alarm());
        assertTrue(t1.alarm());
    }

    @Test
    public void testCancelAlarm() {
        Turnstile t = new Turnstile();
        t.pass();
        t.coin();
        Turnstile t1 = new Turnstile();
        assertTrue(!t1.alarm());
        assertTrue(!t1.locked());
        assertEquals(1, t1.coins());
        assertEquals(0, t1.refunds());
    }

    @Test
    public void testTwoOperations() {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();
        t.coin();
        assertTrue(!t.locked());
        assertEquals(2, t.coins());
        t.pass();
        assertTrue(t.locked());
    }
}
