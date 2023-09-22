package com.farhad.example.codekata.Bank_kata.impl2.matchers;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class DayMonthYearMatcher extends BaseMatcher<LocalDate> {

    private int day;
    private int month;
    private int year;

    private LocalDate expectedDate;

    public DayMonthYearMatcher(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.expectedDate = LocalDate.of(year, month, day);
    }

    public static DayMonthYearMatcher hasDayMonthYear(int day, int month, int year) {
        return new DayMonthYearMatcher(day, month, year);
    }

    @Override
    public boolean matches(Object dateObject) {
        return expectedDate.isEqual((ChronoLocalDate)dateObject);
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expectedDate);
    }
    
}
