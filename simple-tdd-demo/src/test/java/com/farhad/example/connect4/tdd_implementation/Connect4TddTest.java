package com.farhad.example.connect4.tdd_implementation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
}
