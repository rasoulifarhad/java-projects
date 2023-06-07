package com.farhad.example.datetime;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class TemporalFormat {
    
    public static String format(Temporal temporal, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(temporal);
    }

}
