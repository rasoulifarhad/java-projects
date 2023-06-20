package com.farhad.example.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaysBetweenDatesDemoTest {
    
    @Test
    public void daysBetweenTwoDate() {
        Date dateBefore = new Date(2023, Calendar.APRIL, 21 );
        Date dateAfter = new Date(2023, Calendar.APRIL, 25);
        long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        log.info("days: {}", daysDiff);
    }

    @Test
    public void daysBetweenTwoDateWithDateFormat() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date dateBefore = format.parse("04/21/2023");
            Date dateAfter = format.parse("04/25/2023");
            long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
            long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
            log.info("Days: {}", daysDiff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void daysBetweenTwoDateWithCalander() {
        GregorianCalendar befor = new GregorianCalendar(2023, 4, 21);
        GregorianCalendar after = new GregorianCalendar(2023, 4, 25);

        Date dateBefore = befor.getTime();
        Date dateAfter = after.getTime();
        long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        log.info("days: {}", daysDiff);
    }

    @Test
    public void daysBetweenTwoLocalDate() {
        LocalDate dateBefore = LocalDate.parse("2023-04-21");
        LocalDate dateAfter = LocalDate.parse("2023-04-25");
        long daysDiff = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        log.info("Days: {}", daysDiff);

        long daysDiff2 = dateBefore.until(dateAfter, ChronoUnit.DAYS);
        log.info("Days: {}", daysDiff2);
    }

    @Test
    public void daysBetweenTwoLocalDateWithPeriod() {
        LocalDate dateBefore = LocalDate.of(2023, Month.JANUARY, 21);
        LocalDate dateAfter = LocalDate.of(2023, Month.APRIL, 25);

        Period period = Period.between(dateBefore, dateAfter);
        long yearsDiff = period.getYears();
        long monthsDiff = period.getMonths();
        long daysDiff = period.getDays();
        log.info("years: {} , months: {}, Days: {}", yearsDiff, monthsDiff, daysDiff);
    }

}
