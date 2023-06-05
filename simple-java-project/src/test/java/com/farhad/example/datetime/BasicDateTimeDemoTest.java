package com.farhad.example.datetime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicDateTimeDemoTest {

    private BasicDateTimeDemo demo;
    @BeforeEach
    void setUp() {
        demo = new BasicDateTimeDemo();
    }

    @AfterEach
    void tearDown() {
        demo = null;
    }


    @Test
    void testDemonstrateLocalDateWithTemporalAdjusters() {
        demo.demonstrateLocalDateWithTemporalAdjusters();
    }

    @Test
    void testDemonstrateLocalDateWithPlusYears() {
        demo.demonstrateLocalDateWithPlusYears();
    }

    @Test
    void testDemonstrateDayOfWeekEnumWithPlus() {
        demo.demonstrateDayOfWeekEnumWithMethods();
    }

    @Test
    void testDemonstrateMonthEnumWithMetodes() {
        demo.demonstrateMonthEnumWithMetodes();
    }

    @Test
    void testDemonstrateLocalDate() {
        demo.demonstrateLocalDate();
    }

    @Test
    void testDemonstrateYearMonth() {
        demo.demonstrateYearMonth();
    }

    @Test
    void testDemonstrateMonthDay() {
        demo.demonstrateMonthDay();
    }

    @Test
    void testDemonstrateYear() {
        demo.demonstrateYear();
    }

    @Test
    void testDemonstradeLocalDateTime() {
        demo.demonstradeLocalDateTime();
    }

    @Test
    void testDemonstradeLocalTime() {
        demo.demonstradeLocalTime();
    }

    @Test
    void testDemonstrateZoneIdAndZoneOffset() {
        demo.demonstrateZoneIdAndZoneOffset();
    }

    @Test
    void testDemonstrateZonedDateTime() {
        demo.demonstrateZonedDateTime();
    }

    @Test
    void testDemonstrateOffsetTime() {
        demo.demonstrateOffsetTime();
    }

    @Test
    void testDemonstrateInstant() {
        demo.demonstrateInstant();
    }
}
