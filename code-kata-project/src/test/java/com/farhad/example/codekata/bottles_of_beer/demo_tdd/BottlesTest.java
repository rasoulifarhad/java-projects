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

    @Test
    public void verse97() {
        String expected = 
            "97 bottles of beer on the wall, " +
            "97 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "96 bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(97)));
    }

    @Test
    public void verse2() {
        String expected = 
            "2 bottles of beer on the wall, " +
            "2 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "1 bottle of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(2)));
    }

    @Test
    public void verse1() {
        String expected = 
            "1 bottle of beer on the wall, " +
            "1 bottle of beer.\n" +
            "Take it down and pass it around, " +
            "no more bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(1)));
    }

    @Test
    public void verse0() {
        String expected = 
            "No more bottles of beer on the wall, " + 
            "no more bottles of beer.\n" +
            "Go to the store and buy some more, " +
            "99 bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(0)));
    }

    @Test
    public void aCoupleVerses() {
        String expected = 
            "99 bottles of beer on the wall, " +
            "99 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "98 bottles of beer on the wall.\n" +
            "\n" +
            "98 bottles of beer on the wall, " +
            "98 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "97 bottles of beer on the wall.\n";
    assertThat(expected, is(new Bottles().verses(99,98)));
    }

    @Test
    public void aFewVerses() {
        String expected = 
            "2 bottles of beer on the wall, " +
            "2 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "1 bottle of beer on the wall.\n" +
            "\n" +
            "1 bottle of beer on the wall, " +
            "1 bottle of beer.\n" +
            "Take it down and pass it around, " +
            "no more bottles of beer on the wall.\n" + 
            "\n" +
            "No more bottles of beer on the wall, " + 
            "no more bottles of beer.\n" +
            "Go to the store and buy some more, " +
            "99 bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verses(2,0)));
    }
}
