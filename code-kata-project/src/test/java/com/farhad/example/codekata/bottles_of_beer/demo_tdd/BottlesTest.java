package com.farhad.example.codekata.bottles_of_beer.demo_tdd;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class BottlesTest {

    @Test
    public void theFirstVerse() {
        String expected = 
            "99 bottles of beer on the wall, " +
            "99 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "98 bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(99)));
    }

    @Test
    public void anotherVerse() {
        String expected = 
            "3 bottles of beer on the wall, " +
            "3 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "2 bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(3)));
    }

}
