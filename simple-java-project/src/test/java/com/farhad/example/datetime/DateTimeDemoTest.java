package com.farhad.example.datetime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateTimeDemoTest {

    private DateTimeDemo demo;
    @BeforeEach
    void setUp() {
        demo = new DateTimeDemo();
    }

    @AfterEach
    void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateSimpleDateFormatFormating() {
        demo.demonstrateSimpleDateFormatFormating();
    }

    @Test
    void testDemonstrateSimpleDateFormatParsing() {
        demo.demonstrateSimpleDateFormatParsing();
    }

    @Test
    void testDemonstrateDateTimeFormatFormating() {
        demo.demonstrateDateTimeFormatFormating();
    }

    @Test
    void testDemonstrateDateTimeFormatParsingStaticMethode() {
        demo.demonstrateDateTimeFormatParsingStaticMethode();
    }

    @Test
    void testDemonstrateDateTimeFormatParsingMethodeReference() {
        demo.demonstrateDateTimeFormatParsingMethodeReference();
    }

    @Test
    void testDemonstrateDateTimeFormatAndFormatFormating() {
        demo.demonstrateDateTimeFormatAndFormatFormating();
    }

    @Test
    void testDemonstrateDateTimeFormatFormattingAndParsingInstant() {
        demo.demonstrateDateTimeFormatFormattingAndParsingInstant();
    }
}
