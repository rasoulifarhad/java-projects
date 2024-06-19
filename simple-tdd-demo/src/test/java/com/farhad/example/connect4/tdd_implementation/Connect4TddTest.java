package com.farhad.example.connect4.tdd_implementation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Connect4TddTest {

    private Connect4Tdd subject;
    private OutputStream output;

    @BeforeEach
    public void srtup() {
        output = new ByteArrayOutputStream();
        subject = new Connect4Tdd(
            new PrintStream(output)
        );
    }

    @Test
    public void whenTheGameIsStartedTheBoardIsEmpty() {
        assertThat(subject.getNumberOfDiscs(), is(0));
    }

    @Test
    public void whenDiscOutsideBoardThenRuntimeException() {
        int column = -1;
        
        assertThrows(RuntimeException.class, () -> {
            subject.putDiscInColumn(column);
        }, "Invalid column " + column);
    }

    @Test
    public void whenFirstDiscInsertedInColumnThenPositionIsZero() {
        int column = 1;
        assertThat(subject.putDiscInColumn(column), is(0));
    }


    @Test
    public void whenSecondDiscInsertedInColumnThenPositionIsOne() {
        int column = 1;
        subject.putDiscInColumn(column);
        assertThat(subject.putDiscInColumn(column), is(1));
    }

    @Test
    public void whenDiscInsertedInColumnThenNumberOfDiscsIncreased() {
        int column = 1;
        subject.putDiscInColumn(column);
        assertThat(subject.getNumberOfDiscs(), is(1));
    }

    @Test
    public void whenNoMoreRoomInColumnThenRuntimeException(){
        int column = 1;
        int maxDiscsInColumn = 6;
        for (int times = 0; times <maxDiscsInColumn; ++times) {
            subject.putDiscInColumn(column);
        }
        assertThrows(RuntimeException.class, () -> {
            subject.putDiscInColumn(column);
        }, "No more room in column " + column);
    }

    @Test
    public void whenFirstPlayerPlaysThenDiscColorIsRed() {
        assertThat(subject.getCurrentPlayer(), is("R"));
    }

    @Test
    public void whenSecondPlayerPlaysThenDiscColorIsGreen() {
        int column = 1;
        subject.putDiscInColumn(column);
        assertThat(subject.getCurrentPlayer(), is("G"));
    }

    @Test
    public void whenAskedForCurrentPlayerTheOutputNotice() {
        subject.getCurrentPlayer();
        assertThat(output.toString(), containsString("Player R turn"));
    }
    @Test
    public void whenADiscIsIntroducedTheBoardIsPrinted() {

        int column = 1;
        subject.putDiscInColumn(column);
        assertThat(output.toString(), 
            containsString("| |R| | | | | |"));
    }

    @Test
    public void whenTheGameStartsItIsNotFinished() {
        assertFalse(subject.isFinished(), "The game must not be finished");
    }

    @Test
    public void whenNoDiscCanBeIntroducedTheGameIsFinished() {
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                subject.putDiscInColumn(column);
            }
        }
        assertTrue(subject.isFinished(), "The game must be finished");
    }

    @Test 
    public void when4VerticalDiscsAreConnectedThenPlayerWins() {
        for (int row = 0; row < 3; row++) {
            subject.putDiscInColumn(1); // R
            subject.putDiscInColumn(2); // G
        }
        assertThat(subject.getWinner(), isEmptyString());
        subject.putDiscInColumn(1); // R
        assertThat(subject.getWinner(), is("R"));
    }

    @Test 
    public void when4HorizontalDiscsAreConnectedThenPlayerWins() {
        int column;
        for (column = 0; column < 3; column++) {
            subject.putDiscInColumn(column); // R
            subject.putDiscInColumn(column); // G
        }
        assertThat(subject.getWinner(), isEmptyString());
        subject.putDiscInColumn(column); // R
        assertThat(subject.getWinner(), is("R"));
    }

    @Test 
    public void when4Diagonal1DiscsAreConnectedThenThatPlayerWins() {
        int [] gamePlay = new int[] {1, 2, 2, 3, 4, 3, 3, 4, 4, 5, 4};
        for (int column : gamePlay) {
            subject.putDiscInColumn(column);
        }
        System.out.println(subject.getWinner());
        assertThat(subject.getWinner(), is("R"));
    }

    @Test 
    public void when4Diagonal2DiscsAreConnectedThenThatPlayerWins() {
        int [] gamePlay = new int[] {3, 4, 2, 3, 2, 2, 1, 1, 1, 1};
        for (int column : gamePlay) {
            subject.putDiscInColumn(column);
        }
        assertThat(subject.getWinner(), is("G"));
    }

    @Test
    public void t() {
        Pattern p = Pattern.compile(".*R{4}.*");
        assertTrue(p.matcher("RRRR ").matches());
        assertTrue(p.matcher("RRRR ").matches());
        assertTrue(p.matcher("RRRR ").matches());
        assertTrue(p.matcher("RRRR ").matches());
    }

}
