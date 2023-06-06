package com.farhad.example.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrentDataTimeDemo {
    
    public static void currentTimeUsingDateAndDateFormat() {
        Date date = new Date();
        String stringTimeFormat = "hh:mm:ss a";
        DateFormat timeFormatter = new SimpleDateFormat(stringTimeFormat);
        String formatedTime = timeFormatter.format(date);
        log.info("Current Time of the day: {} (12h format)", formatedTime);
    }

    public static void currentTimeUsingCalendarAndDateFormat() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String stringTimeFormat = "hh:mm:ss a";
        DateFormat timeFormatter = new SimpleDateFormat(stringTimeFormat);
        String formatedTime = timeFormatter.format(date);
        log.info("Current Time of the day: {} (12h format)", formatedTime);
    }

    public static void currentTimeOfDefaultTimeZone() {
        LocalTime localTime = LocalTime.now();
        log.info("Current Time of the day: {} (your timezone)", localTime);
    }

    public static void currentTimeOfTimeZone() {
        ZoneId laZoneId = ZoneId.of("America/Los_Angeles");
        LocalTime laLocalTime = LocalTime.now(laZoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        log.info("Current Time of the day: {} in {} zone", laLocalTime.format(formatter), laZoneId.toString());
    }

    public static void currentTimeOfTimeOffset() {
        ZoneOffset laZoneOffset = ZoneOffset.of("-07:00");
        ZoneId laZoneId = ZoneId.ofOffset("UTC", laZoneOffset);
        LocalTime laLocalTime = LocalTime.now(laZoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        log.info("Current Time of the day: {} in {} zone", laLocalTime.format(formatter), laZoneId.toString());
    }
 
}
