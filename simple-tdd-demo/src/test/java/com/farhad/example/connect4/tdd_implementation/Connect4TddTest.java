package com.farhad.example.connect4.tdd_implementation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Connect4TddTest {

    private Connect4Tdd subject;

    @BeforeEach
    public void srtup() {
        subject = new Connect4Tdd();
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
}
