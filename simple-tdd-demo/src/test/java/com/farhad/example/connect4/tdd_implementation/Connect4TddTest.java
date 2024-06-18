package com.farhad.example.connect4.tdd_implementation;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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
        MatcherAssert.assertThat(subject.getNumberOfDiscs(), Matchers.is(0));
    }

}
