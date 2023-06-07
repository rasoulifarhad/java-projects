package com.farhad.example.datetime;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class FamilyBirthdays {

    public static Boolean isFamilyBirthday(TemporalAccessor date) {

        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        // My birthday January 24 1977
        if ( (month == Month.JANUARY.getValue()) && (day == 24)){
            return true;
        }
        return false;
    }
    
}
