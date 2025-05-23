package com.farhad.example.codekata.bottles_of_beer.demo_tdd;


import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

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

    // BADDDDDDDDDDDDDDDDDDDDDd!
    @Test
    @Disabled
    public void theWholeSongBadly() {
        assertThat(new Bottles().verses(99, 0), is(new Bottles().song()));
    }

    // Consider what just happened. The original test asserts that sending song
    // produces the same result as running the code currently contained in song.
    // The song test should know nothing about how the Bottles class produces the song.
    //
    // The clear and unambiguous expectation here is that song return the complete set 
    // of lyrics, and the best and easiest way to test song is to explicitly assert that 
    // it does.
    @Test
    @Disabled
    public void theWholeSongAgainBadly() {
        Bottles bottles = new Bottles();
        String expected = revRange(0, 99)
            .mapToObj(v -> bottles.verse(v))
            .collect(joining("\n"));
        assertThat(expected, is(new Bottles().song()));
    }

    static IntStream revRange(int from, int to) {
        return IntStream.rangeClosed(from, to)
                    .map(i -> to - i + from );
    }


    // The text needed for 100 verses is fairly lengthy, and you may resist writing 
    // out the full string because of concerns about duplication.
    @Test
    public void theWholeSong() {
        String expected = 
            "99 bottles of beer on the wall, 99 bottles of beer.\n" +
            "Take one down and pass it around, 98 bottles of beer on the wall.\n" +
            "\n" +
            "98 bottles of beer on the wall, 98 bottles of beer.\n" +
            "Take one down and pass it around, 97 bottles of beer on the wall.\n" +
            "\n" +
            "97 bottles of beer on the wall, 97 bottles of beer.\n" +
            "Take one down and pass it around, 96 bottles of beer on the wall.\n" +
            "\n" +
            "96 bottles of beer on the wall, 96 bottles of beer.\n" +
            "Take one down and pass it around, 95 bottles of beer on the wall.\n" +
            "\n" +
            "95 bottles of beer on the wall, 95 bottles of beer.\n" +
            "Take one down and pass it around, 94 bottles of beer on the wall.\n" +
            "\n" +
            "94 bottles of beer on the wall, 94 bottles of beer.\n" +
            "Take one down and pass it around, 93 bottles of beer on the wall.\n" +
            "\n" +
            "93 bottles of beer on the wall, 93 bottles of beer.\n" +
            "Take one down and pass it around, 92 bottles of beer on the wall.\n" +
            "\n" +
            "92 bottles of beer on the wall, 92 bottles of beer.\n" +
            "Take one down and pass it around, 91 bottles of beer on the wall.\n" +
            "\n" +
            "91 bottles of beer on the wall, 91 bottles of beer.\n" +
            "Take one down and pass it around, 90 bottles of beer on the wall.\n" +
            "\n" +
            "90 bottles of beer on the wall, 90 bottles of beer.\n" +
            "Take one down and pass it around, 89 bottles of beer on the wall.\n" +
            "\n" +
            "89 bottles of beer on the wall, 89 bottles of beer.\n" +
            "Take one down and pass it around, 88 bottles of beer on the wall.\n" +
            "\n" +
            "88 bottles of beer on the wall, 88 bottles of beer.\n" +
            "Take one down and pass it around, 87 bottles of beer on the wall.\n" +
            "\n" +
            "87 bottles of beer on the wall, 87 bottles of beer.\n" +
            "Take one down and pass it around, 86 bottles of beer on the wall.\n" +
            "\n" +
            "86 bottles of beer on the wall, 86 bottles of beer.\n" +
            "Take one down and pass it around, 85 bottles of beer on the wall.\n" +
            "\n" +
            "85 bottles of beer on the wall, 85 bottles of beer.\n" +
            "Take one down and pass it around, 84 bottles of beer on the wall.\n" +
            "\n" +
            "84 bottles of beer on the wall, 84 bottles of beer.\n" +
            "Take one down and pass it around, 83 bottles of beer on the wall.\n" +
            "\n" +
            "83 bottles of beer on the wall, 83 bottles of beer.\n" +
            "Take one down and pass it around, 82 bottles of beer on the wall.\n" +
            "\n" +
            "82 bottles of beer on the wall, 82 bottles of beer.\n" +
            "Take one down and pass it around, 81 bottles of beer on the wall.\n" +
            "\n" +
            "81 bottles of beer on the wall, 81 bottles of beer.\n" +
            "Take one down and pass it around, 80 bottles of beer on the wall.\n" +
            "\n" +
            "80 bottles of beer on the wall, 80 bottles of beer.\n" +
            "Take one down and pass it around, 79 bottles of beer on the wall.\n" +
            "\n" +
            "79 bottles of beer on the wall, 79 bottles of beer.\n" +
            "Take one down and pass it around, 78 bottles of beer on the wall.\n" +
            "\n" +
            "78 bottles of beer on the wall, 78 bottles of beer.\n" +
            "Take one down and pass it around, 77 bottles of beer on the wall.\n" +
            "\n" +
            "77 bottles of beer on the wall, 77 bottles of beer.\n" +
            "Take one down and pass it around, 76 bottles of beer on the wall.\n" +
            "\n" +
            "76 bottles of beer on the wall, 76 bottles of beer.\n" +
            "Take one down and pass it around, 75 bottles of beer on the wall.\n" +
            "\n" +
            "75 bottles of beer on the wall, 75 bottles of beer.\n" +
            "Take one down and pass it around, 74 bottles of beer on the wall.\n" +
            "\n" +
            "74 bottles of beer on the wall, 74 bottles of beer.\n" +
            "Take one down and pass it around, 73 bottles of beer on the wall.\n" +
            "\n" +
            "73 bottles of beer on the wall, 73 bottles of beer.\n" +
            "Take one down and pass it around, 72 bottles of beer on the wall.\n" +
            "\n" +
            "72 bottles of beer on the wall, 72 bottles of beer.\n" +
            "Take one down and pass it around, 71 bottles of beer on the wall.\n" +
            "\n" +
            "71 bottles of beer on the wall, 71 bottles of beer.\n" +
            "Take one down and pass it around, 70 bottles of beer on the wall.\n" +
            "\n" +
            "70 bottles of beer on the wall, 70 bottles of beer.\n" +
            "Take one down and pass it around, 69 bottles of beer on the wall.\n" +
            "\n" +
            "69 bottles of beer on the wall, 69 bottles of beer.\n" +
            "Take one down and pass it around, 68 bottles of beer on the wall.\n" +
            "\n" +
            "68 bottles of beer on the wall, 68 bottles of beer.\n" +
            "Take one down and pass it around, 67 bottles of beer on the wall.\n" +
            "\n" +
            "67 bottles of beer on the wall, 67 bottles of beer.\n" +
            "Take one down and pass it around, 66 bottles of beer on the wall.\n" +
            "\n" +
            "66 bottles of beer on the wall, 66 bottles of beer.\n" +
            "Take one down and pass it around, 65 bottles of beer on the wall.\n" +
            "\n" +
            "65 bottles of beer on the wall, 65 bottles of beer.\n" +
            "Take one down and pass it around, 64 bottles of beer on the wall.\n" +
            "\n" +
            "64 bottles of beer on the wall, 64 bottles of beer.\n" +
            "Take one down and pass it around, 63 bottles of beer on the wall.\n" +
            "\n" +
            "63 bottles of beer on the wall, 63 bottles of beer.\n" +
            "Take one down and pass it around, 62 bottles of beer on the wall.\n" +
            "\n" +
            "62 bottles of beer on the wall, 62 bottles of beer.\n" +
            "Take one down and pass it around, 61 bottles of beer on the wall.\n" +
            "\n" +
            "61 bottles of beer on the wall, 61 bottles of beer.\n" +
            "Take one down and pass it around, 60 bottles of beer on the wall.\n" +
            "\n" +
            "60 bottles of beer on the wall, 60 bottles of beer.\n" +
            "Take one down and pass it around, 59 bottles of beer on the wall.\n" +
            "\n" +
            "59 bottles of beer on the wall, 59 bottles of beer.\n" +
            "Take one down and pass it around, 58 bottles of beer on the wall.\n" +
            "\n" +
            "58 bottles of beer on the wall, 58 bottles of beer.\n" +
            "Take one down and pass it around, 57 bottles of beer on the wall.\n" +
            "\n" +
            "57 bottles of beer on the wall, 57 bottles of beer.\n" +
            "Take one down and pass it around, 56 bottles of beer on the wall.\n" +
            "\n" +
            "56 bottles of beer on the wall, 56 bottles of beer.\n" +
            "Take one down and pass it around, 55 bottles of beer on the wall.\n" +
            "\n" +
            "55 bottles of beer on the wall, 55 bottles of beer.\n" +
            "Take one down and pass it around, 54 bottles of beer on the wall.\n" +
            "\n" +
            "54 bottles of beer on the wall, 54 bottles of beer.\n" +
            "Take one down and pass it around, 53 bottles of beer on the wall.\n" +
            "\n" +
            "53 bottles of beer on the wall, 53 bottles of beer.\n" +
            "Take one down and pass it around, 52 bottles of beer on the wall.\n" +
            "\n" +
            "52 bottles of beer on the wall, 52 bottles of beer.\n" +
            "Take one down and pass it around, 51 bottles of beer on the wall.\n" +
            "\n" +
            "51 bottles of beer on the wall, 51 bottles of beer.\n" +
            "Take one down and pass it around, 50 bottles of beer on the wall.\n" +
            "\n" +
            "50 bottles of beer on the wall, 50 bottles of beer.\n" +
            "Take one down and pass it around, 49 bottles of beer on the wall.\n" +
            "\n" +
            "49 bottles of beer on the wall, 49 bottles of beer.\n" +
            "Take one down and pass it around, 48 bottles of beer on the wall.\n" +
            "\n" +
            "48 bottles of beer on the wall, 48 bottles of beer.\n" +
            "Take one down and pass it around, 47 bottles of beer on the wall.\n" +
            "\n" +
            "47 bottles of beer on the wall, 47 bottles of beer.\n" +
            "Take one down and pass it around, 46 bottles of beer on the wall.\n" +
            "\n" +
            "46 bottles of beer on the wall, 46 bottles of beer.\n" +
            "Take one down and pass it around, 45 bottles of beer on the wall.\n" +
            "\n" +
            "45 bottles of beer on the wall, 45 bottles of beer.\n" +
            "Take one down and pass it around, 44 bottles of beer on the wall.\n" +
            "\n" +
            "44 bottles of beer on the wall, 44 bottles of beer.\n" +
            "Take one down and pass it around, 43 bottles of beer on the wall.\n" +
            "\n" +
            "43 bottles of beer on the wall, 43 bottles of beer.\n" +
            "Take one down and pass it around, 42 bottles of beer on the wall.\n" +
            "\n" +
            "42 bottles of beer on the wall, 42 bottles of beer.\n" +
            "Take one down and pass it around, 41 bottles of beer on the wall.\n" +
            "\n" +
            "41 bottles of beer on the wall, 41 bottles of beer.\n" +
            "Take one down and pass it around, 40 bottles of beer on the wall.\n" +
            "\n" +
            "40 bottles of beer on the wall, 40 bottles of beer.\n" +
            "Take one down and pass it around, 39 bottles of beer on the wall.\n" +
            "\n" +
            "39 bottles of beer on the wall, 39 bottles of beer.\n" +
            "Take one down and pass it around, 38 bottles of beer on the wall.\n" +
            "\n" +
            "38 bottles of beer on the wall, 38 bottles of beer.\n" +
            "Take one down and pass it around, 37 bottles of beer on the wall.\n" +
            "\n" +
            "37 bottles of beer on the wall, 37 bottles of beer.\n" +
            "Take one down and pass it around, 36 bottles of beer on the wall.\n" +
            "\n" +
            "36 bottles of beer on the wall, 36 bottles of beer.\n" +
            "Take one down and pass it around, 35 bottles of beer on the wall.\n" +
            "\n" +
            "35 bottles of beer on the wall, 35 bottles of beer.\n" +
            "Take one down and pass it around, 34 bottles of beer on the wall.\n" +
            "\n" +
            "34 bottles of beer on the wall, 34 bottles of beer.\n" +
            "Take one down and pass it around, 33 bottles of beer on the wall.\n" +
            "\n" +
            "33 bottles of beer on the wall, 33 bottles of beer.\n" +
            "Take one down and pass it around, 32 bottles of beer on the wall.\n" +
            "\n" +
            "32 bottles of beer on the wall, 32 bottles of beer.\n" +
            "Take one down and pass it around, 31 bottles of beer on the wall.\n" +
            "\n" +
            "31 bottles of beer on the wall, 31 bottles of beer.\n" +
            "Take one down and pass it around, 30 bottles of beer on the wall.\n" +
            "\n" +
            "30 bottles of beer on the wall, 30 bottles of beer.\n" +
            "Take one down and pass it around, 29 bottles of beer on the wall.\n" +
            "\n" +
            "29 bottles of beer on the wall, 29 bottles of beer.\n" +
            "Take one down and pass it around, 28 bottles of beer on the wall.\n" +
            "\n" +
            "28 bottles of beer on the wall, 28 bottles of beer.\n" +
            "Take one down and pass it around, 27 bottles of beer on the wall.\n" +
            "\n" +
            "27 bottles of beer on the wall, 27 bottles of beer.\n" +
            "Take one down and pass it around, 26 bottles of beer on the wall.\n" +
            "\n" +
            "26 bottles of beer on the wall, 26 bottles of beer.\n" +
            "Take one down and pass it around, 25 bottles of beer on the wall.\n" +
            "\n" +
            "25 bottles of beer on the wall, 25 bottles of beer.\n" +
            "Take one down and pass it around, 24 bottles of beer on the wall.\n" +
            "\n" +
            "24 bottles of beer on the wall, 24 bottles of beer.\n" +
            "Take one down and pass it around, 23 bottles of beer on the wall.\n" +
            "\n" +
            "23 bottles of beer on the wall, 23 bottles of beer.\n" +
            "Take one down and pass it around, 22 bottles of beer on the wall.\n" +
            "\n" +
            "22 bottles of beer on the wall, 22 bottles of beer.\n" +
            "Take one down and pass it around, 21 bottles of beer on the wall.\n" +
            "\n" +
            "21 bottles of beer on the wall, 21 bottles of beer.\n" +
            "Take one down and pass it around, 20 bottles of beer on the wall.\n" +
            "\n" +
            "20 bottles of beer on the wall, 20 bottles of beer.\n" +
            "Take one down and pass it around, 19 bottles of beer on the wall.\n" +
            "\n" +
            "19 bottles of beer on the wall, 19 bottles of beer.\n" +
            "Take one down and pass it around, 18 bottles of beer on the wall.\n" +
            "\n" +
            "18 bottles of beer on the wall, 18 bottles of beer.\n" +
            "Take one down and pass it around, 17 bottles of beer on the wall.\n" +
            "\n" +
            "17 bottles of beer on the wall, 17 bottles of beer.\n" +
            "Take one down and pass it around, 16 bottles of beer on the wall.\n" +
            "\n" +
            "16 bottles of beer on the wall, 16 bottles of beer.\n" +
            "Take one down and pass it around, 15 bottles of beer on the wall.\n" +
            "\n" +
            "15 bottles of beer on the wall, 15 bottles of beer.\n" +
            "Take one down and pass it around, 14 bottles of beer on the wall.\n" +
            "\n" +
            "14 bottles of beer on the wall, 14 bottles of beer.\n" +
            "Take one down and pass it around, 13 bottles of beer on the wall.\n" +
            "\n" +
            "13 bottles of beer on the wall, 13 bottles of beer.\n" +
            "Take one down and pass it around, 12 bottles of beer on the wall.\n" +
            "\n" +
            "12 bottles of beer on the wall, 12 bottles of beer.\n" +
            "Take one down and pass it around, 11 bottles of beer on the wall.\n" +
            "\n" +
            "11 bottles of beer on the wall, 11 bottles of beer.\n" +
            "Take one down and pass it around, 10 bottles of beer on the wall.\n" +
            "\n" +
            "10 bottles of beer on the wall, 10 bottles of beer.\n" +
            "Take one down and pass it around, 9 bottles of beer on the wall.\n" +
            "\n" +
            "9 bottles of beer on the wall, 9 bottles of beer.\n" +
            "Take one down and pass it around, 8 bottles of beer on the wall.\n" +
            "\n" +
            "8 bottles of beer on the wall, 8 bottles of beer.\n" +
            "Take one down and pass it around, 7 bottles of beer on the wall.\n" +
            "\n" +
            "7 bottles of beer on the wall, 7 bottles of beer.\n" +
            "Take one down and pass it around, 1 six-pack of beer on the wall.\n" +
            "\n" +
            "1 six-pack of beer on the wall, 1 six-pack of beer.\n" +
            "Take one down and pass it around, 5 bottles of beer on the wall.\n" +
            "\n" +
            "5 bottles of beer on the wall, 5 bottles of beer.\n" +
            "Take one down and pass it around, 4 bottles of beer on the wall.\n" +
            "\n" +
            "4 bottles of beer on the wall, 4 bottles of beer.\n" +
            "Take one down and pass it around, 3 bottles of beer on the wall.\n" +
            "\n" +
            "3 bottles of beer on the wall, 3 bottles of beer.\n" +
            "Take one down and pass it around, 2 bottles of beer on the wall.\n" +
            "\n" +
            "2 bottles of beer on the wall, 2 bottles of beer.\n" +
            "Take one down and pass it around, 1 bottle of beer on the wall.\n" +
            "\n" +
            "1 bottle of beer on the wall, 1 bottle of beer.\n" +
            "Take it down and pass it around, no more bottles of beer on the wall.\n" +
            "\n" +
            "No more bottles of beer on the wall, no more bottles of beer.\n" +
            "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().song()));
    }

    @Test
    public void verse6() {
        String expected = 
            "1 six-pack of beer on the wall, " +
            "1 six-pack of beer.\n" +
            "Take one down and pass it around, " +
            "5 bottles of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(6)));
    }

    @Test
    public void verse7() {
        String expected = 
            "7 bottles of beer on the wall, " +
            "7 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "1 six-pack of beer on the wall.\n";
        assertThat(expected, is(new Bottles().verse(7)));
    }

}
