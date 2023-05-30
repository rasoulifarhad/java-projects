package com.farhad.example.datetime;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrentDataTimeDemoTest {
    
    @Test
    public void currentTimeUsingDateAndDateFormatTest() {
        CurrentDataTimeDemo.currentTimeUsingDateAndDateFormat();
    }

    @Test
    public void currentTimeUsingCalendarAndDateFormatTest() {
        CurrentDataTimeDemo.currentTimeUsingCalendarAndDateFormat();
    }

    @Test
    public void currentTimeOfDefaultTimeZoneTest() {
        CurrentDataTimeDemo.currentTimeOfDefaultTimeZone();
    }

    @Test
    public void currentTimeOfTimeZoneTest() {
        CurrentDataTimeDemo.currentTimeOfTimeZone();
    }

    @Test
    public void currentTimeOfTimeOffsetTest() {
        CurrentDataTimeDemo.currentTimeOfTimeOffset();
    }
}
