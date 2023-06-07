package com.farhad.example.datetime;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class Vacations implements TemporalQuery<Boolean> {

    // Nowruz(1403): From 19 march  to 1 april
    
    @Override
    public Boolean queryFrom(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        if( (month == Month.MARCH.getValue()) && (day>=19 ) ) {
            return Boolean.TRUE;
        }

        if( (month == Month.APRIL.getValue()) && (day == 1 ) ) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
    
}
