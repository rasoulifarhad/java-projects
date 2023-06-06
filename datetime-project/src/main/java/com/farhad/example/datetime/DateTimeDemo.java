package com.farhad.example.datetime;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateTimeDemo {
    
    private final String dateTimeFormatPattern = "yyyy-MM-dd HH:mm:ss z";
    private final Date now = new Date();
    private final ZonedDateTime now8 = ZonedDateTime.now();
    private final String dateTimeString = "2023/04/03 14:59:54 MDT";

    public void demonstrateSimpleDateFormatFormating() {
        final DateFormat format = new SimpleDateFormat(dateTimeFormatPattern);
        final String nowString = format.format(now);
        log.info("Date '{}' formated with SimpleDateFormat and `{}`: {} ", now, dateTimeFormatPattern, nowString);
    }

    public void demonstrateSimpleDateFormatParsing() {
        final DateFormat format = new SimpleDateFormat(dateTimeFormatPattern);
        try {
            final Date parsedDate = format.parse(dateTimeString);
            log.info("`{}` is parsed  with SimpleSateFormat as: {}", dateTimeString, parsedDate);
        } catch (ParseException e) {
            log.error("Unable to parse `{}` with pattern `{}`", dateTimeString, dateTimeFormatPattern);
            e.printStackTrace();
        }
    }

    public void demonstrateDateTimeFormatFormating() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
        final String now8String = formatter.format(now8);
        log.info("'{}' formated with DateTimeFormatter and `{}`: {} ", now8, dateTimeFormatPattern, now8String);
    }

    public void demonstrateDateTimeFormatParsingStaticMethode() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
        final ZonedDateTime parsedZonedDateTime = ZonedDateTime.parse(dateTimeFormatPattern, formatter);
        log.info("`{}` is parsed  with DateTimeFormatter and ZonedDateTime.parse as: {}", dateTimeString, parsedZonedDateTime);
    }

    public void demonstrateDateTimeFormatParsingMethodeReference() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
        final ZonedDateTime parsedZonedDateTime = formatter.parse(dateTimeString, ZonedDateTime::from);
        log.info("`{}` is parsed  with DateTimeFormatter and ZonedDateTime::from as: {}", dateTimeString, parsedZonedDateTime);
    }

    public void demonstrateDateTimeFormatAndFormatFormating() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
        final Format format = formatter.toFormat();
        final String nowString = format.format(now8);
        log.info("ZonedDateTime '{}' formated with DateTimeFormatter/Format (and {}) and `{}`: {} ", now8, format.getClass().getCanonicalName() , dateTimeFormatPattern, nowString);

    }

    public void demonstrateDateTimeFormatFormattingAndParsingInstant() {
        final Instant instant = now.toInstant();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern)
                                                                    .withZone(ZoneId.systemDefault());
        final String formatedInstant = formatter.format(instant);
        log.info("Instant '{}' formated with DateTimeFoprmater and `{}` to {} ", instant, dateTimeFormatPattern, formatedInstant);

        final Instant instant2 = formatter.parse(formatedInstant, ZonedDateTime::from).toInstant();
        log.info("{} parsed back to {}", formatedInstant, instant2);

    }

    public static void main(String[] args) {
        
        final DateTimeDemo demo = new DateTimeDemo();

        demo.demonstrateSimpleDateFormatFormating();
        demo.demonstrateSimpleDateFormatParsing();
        demo.demonstrateDateTimeFormatFormating();
        demo.demonstrateDateTimeFormatParsingStaticMethode();
        demo.demonstrateDateTimeFormatParsingMethodeReference();
        demo.demonstrateDateTimeFormatAndFormatFormating();
        demo.demonstrateDateTimeFormatFormattingAndParsingInstant();
    }
}
