package com.farhad.example.datetime;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChronoLocalDateConverter {
    
    private static String PATTERN = "M/d/yyyy GGGGG" ;
    public static String toChronoLocalDateString(LocalDate localDate, Chronology chrono) {
        Objects.requireNonNull(localDate);
        chrono = chrono == null ? IsoChronology.INSTANCE : chrono;
        Locale local = Locale.getDefault(Category.FORMAT);
        ChronoLocalDate chronoLocalDate ;

        try {
            chronoLocalDate = chrono.date(localDate);
        } catch (DateTimeException e) {
            log.error("", e);
            chrono = IsoChronology.INSTANCE;
            chronoLocalDate = localDate;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter
                                                .ofLocalizedDate(FormatStyle.SHORT)
                                                .withLocale(local)
                                                .withChronology(chrono)
                                                .withDecimalStyle(DecimalStyle.of(local));
        
        // DateTimeFormatter dateFormatter = DateTimeFormatter
        //                                         .ofPattern(PATTERN);
        return dateFormatter.format(chronoLocalDate);
    }

    public static LocalDate fromChronoLocalDateString(String text, Chronology chrono) {
        Objects.requireNonNull(text);
        chrono = chrono == null? IsoChronology.INSTANCE : chrono;
        Locale local = Locale.getDefault(Category.FORMAT);
        DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
                                                    .parseLenient()
                                                    .appendPattern(PATTERN)
                                                    .toFormatter()
                                                    .withChronology(chrono)
                                                    .withDecimalStyle(DecimalStyle.of(local));
        TemporalAccessor temporalAccessor = dateFormatter.parse(text);
        ChronoLocalDate chronoLocalDate = chrono.date(temporalAccessor);
        return LocalDate.from(chronoLocalDate);
    }
}
