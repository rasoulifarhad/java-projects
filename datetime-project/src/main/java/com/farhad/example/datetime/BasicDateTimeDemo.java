package com.farhad.example.datetime;

import static com.farhad.example.datetime.TemporalFormat.format;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoChronology;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicDateTimeDemo {
    
    public void demonstrateLocalDateWithTemporalAdjusters() {
        LocalDate today = LocalDate.now();
        LocalDate payDate = today.with(TemporalAdjusters.lastDayOfMonth());
        log.info("today {} with TemporalAdjusters.lastDayOfMonth()  {}", today, payDate);
        payDate = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        log.info("today {} with TemporalAdjusters.lastDayOfMonth() and minusDays(2) {}", today, payDate);
    }

    public void demonstrateLocalDateWithPlusYears() {
        // LocalDate dateOfBirth = LocalDate.of(1977,1, 24);
        LocalDate dateOfBirth = LocalDate.of(1977,Month.JANUARY,24);
        LocalDate firstBirthDay = dateOfBirth.plusYears(1);
        log.info("Date of Birth {} and firs birth day {}", dateOfBirth, firstBirthDay);

    }

    public void demonstrateDayOfWeekEnumWithMethods() {
        log.info("{} days after {} is {}", 3, DayOfWeek.MONDAY.name(), DayOfWeek.MONDAY.plus(3));
        log.info("{} days before {} is {}", 1, DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL,Locale.getDefault()), DayOfWeek.MONDAY.minus(1));
        log.info("{} days before {} is {}", 1, DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL,Locale.US), DayOfWeek.MONDAY.minus(1));
    }

    public void demonstrateMonthEnumWithMetodes() {
        Month month = Month.AUGUST;
        Locale locale = Locale.getDefault();
        LocalDate now = LocalDate.now();                                                    

        log.info("Full: {}, NARROW: {}, SHORT: {}", month.getDisplayName(TextStyle.FULL, locale), 
                                                            month.getDisplayName(TextStyle.NARROW, locale), 
                                                            month.getDisplayName(TextStyle.SHORT, locale));
        log.info(" {} is {} days", month.getDisplayName(TextStyle.FULL, locale), month.length(false) );
        log.info(" {} is {} days in leap years", month.getDisplayName(TextStyle.FULL, locale), month.length(true) );
        log.info("{} months before {} is {}", 2, 
                                                    month.getDisplayName(TextStyle.FULL, locale), 
                                                    month.minus(2).getDisplayName(TextStyle.FULL, locale));
        log.info("firstMonthOfQuarter {} is {}", month.getDisplayName(TextStyle.FULL, locale), 
                                                        month.firstMonthOfQuarter());

        log.info("firstDayOfYear {} is {}", month.getDisplayName(TextStyle.FULL, locale), 
                                                    month.firstDayOfYear(false));
        
        log.info("now {} adjusted Into {} result is: {}", now, 
                                                                    month.getDisplayName(TextStyle.FULL, locale),
                                                                    month.adjustInto(now) );

        log.info("now {} adjusted Into {} result is: {}", now, 
                                                                    month.getDisplayName(TextStyle.FULL, locale),
                                                                    now.with(month) );
        log.info("now {} adjusted Into {} result is: {}", now, 
                                                                    month.getDisplayName(TextStyle.FULL, locale),
                                                                    now.withMonth(8) );
    }

    public void demonstrateLocalDate() {
        LocalDate now = LocalDate.of(2023, Month.JUNE, 04);
        LocalDate nextWed = now.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));

        log.info("Next wedensday from {} ({}) is {}", now, now.getDayOfWeek(), nextWed);
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
        nextWed = now.with(temporalAdjuster);
        log.info("Next wedensday from {} ({}) is {}", now, now.getDayOfWeek(), nextWed);
    }

    public void demonstrateYearMonth() {
        YearMonth now = YearMonth.now();
        log.info("{}: {} days ", now, now.lengthOfMonth());

        YearMonth yearMonth = YearMonth.of(2010, Month.FEBRUARY);
        log.info("{}: {} days ", yearMonth, yearMonth.lengthOfMonth());
        yearMonth = YearMonth.of(2012, Month.FEBRUARY);
        log.info("{}: {} days ", yearMonth, yearMonth.lengthOfMonth());
        yearMonth = YearMonth.of(2013, Month.FEBRUARY);
        log.info("{}: {} days ", yearMonth, yearMonth.lengthOfMonth());
    }
    
    public void demonstrateMonthDay() {
        MonthDay monthDay = MonthDay.of(Month.FEBRUARY, 29);
        Locale locale = Locale.getDefault();
        log.info("is {} in {} has 29 days? {}",monthDay.getMonth().getDisplayName(TextStyle.FULL, locale),
                                                                2013,
                                                                monthDay.isValidYear(2013));
        log.info("is {} in {} has 29 days? {}",monthDay.getMonth().getDisplayName(TextStyle.FULL, locale),
                                                                2012,
                                                                monthDay.isValidYear(2012));
    }

    public void demonstrateYear() {

        Year year = Year.of(2012);
        log.info("{} is leap year? {}", year.getValue(), year.isLeap());
        year = Year.of(2013);
        log.info("{} is leap year? {}", year.getValue(), year.isLeap());

        Year year2013 = Year.of(2013);
        Year year2014 = Year.of(2014);
        log.info("{} is after {}? {}", year2013.getValue(), year2014.getValue(), year2013.isAfter(year2014));
        log.info("{} is after {}? {}", year2014.getValue(), year2013.getValue(), year2014.isAfter(year2013));
        log.info("{} is befor {}? {}", year2013.getValue(), year2014.getValue(), year2013.isBefore(year2014));
        log.info("{} is befor {}? {}", year2014.getValue(), year2013.getValue(), year2014.isBefore(year2013));

        Year year2012 = Year.of(2012);
        log.info("year {} has {} days", year2012.getValue(), year2012.length());
        log.info("year {} has {} days", year2013.getValue(), year2013.length());

    }

    public void demonstradeLocalTime() {
        LocalTime thisSec;
        thisSec = LocalTime.now();
        log.info("{}:{}:{}", thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());
    }

    public void demonstradeLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        log.info("now: {}", now);

        LocalDateTime localDateTime = LocalDateTime.of(2023,Month.JUNE, 5, 9, 30);
        log.info("June 5, 2023 @ 09:30am : {}", localDateTime);

        localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        log.info("now (from instant) : {}", localDateTime);

        localDateTime = LocalDateTime.now().plusMonths(6);
        log.info("{} plus {} months : {}", now, 6, localDateTime);

        localDateTime = LocalDateTime.now().minusMonths(6);
        log.info("{} minus {} months : {}", now, 6, localDateTime);
    }

    public void demonstrateZoneIdAndZoneOffset() {
        Set<String> allZones =  ZoneId.getAvailableZoneIds();
        LocalDateTime localDateTime = LocalDateTime.now();
 
        List<String> zoneList = new ArrayList<>(allZones);
        Collections.sort(zoneList);

        for (String s : zoneList) {
            ZoneId zoneId = ZoneId.of(s);
            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
            ZoneOffset zoneOffset = zonedDateTime.getOffset();
            // log.info("{}", String.format("%35s %10s", zoneId, zoneOffset));
            int secondsOfHour =  zoneOffset.getTotalSeconds() % (60 * 60);
            if (secondsOfHour != 0) {
                log.info("{}", String.format("%35s %10s", zoneId, zoneOffset));        
            }
            
        }
    }

    public void demonstrateZonedDateTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

        LocalDateTime leaving = LocalDateTime.of(2023, Month.JUNE, 5, 11, 5);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        String formatedDeparture = departure.format(format);
        log.info("LEAVING: {} ({})", formatedDeparture, leavingZone);

        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(650);
        String formatedArrival = arrival.format(format);
        log.info("ARRAYING: {} ({})", formatedArrival, arrivingZone);

        if(arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {
            log.info("({} daylight saving time will be in effect.)", arrivingZone);
        } else {
            log.info("({} standard time will be in effect.)", arrivingZone);
        }
        
    }

    public void demonstrateOffsetDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, Month.JUNE, 5, 12, 10);
        ZoneOffset offset = ZoneOffset.of("-08:00");

        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
        OffsetDateTime lastThursday = offsetDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        log.info("The last Thursday in June 2023 is {}", lastThursday);
    }

    public void demonstrateOffsetTime() {
        LocalTime nowTime = LocalTime.now();
        ZoneOffset zoneOffset = ZoneOffset.of("-08:00");
        OffsetTime offsetTime = OffsetTime.of(nowTime, zoneOffset);
        log.info("The local time is {}, The offset time is {}", nowTime, offsetTime);
    }

    public void demonstrateInstant() {
        Instant now = Instant.now();
        log.info("Now: {} ", now);
        Instant oneHourLater = now.plus(1, ChronoUnit.HOURS);
        log.info("One hour later: {} ", oneHourLater);
        boolean isNowAfterOneHourLater = now.isAfter(oneHourLater);
        log.info("is {} One hour later: {} ? {}", now, oneHourLater, isNowAfterOneHourLater);
        boolean isNowBeforeOneHourLater = now.isBefore(oneHourLater);
        log.info("is {} One hour before: {} ? {}", now, oneHourLater, isNowBeforeOneHourLater);
        long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.SECONDS);
        log.info("Seconds from epoch {}", secondsFromEpoch);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        log.info("{} {} {}", localDateTime.getMonth(), localDateTime.getDayOfMonth(), localDateTime.getYear());
    }

    public void demonstrateParsing() {
        String dateString = "20230605";
        LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
        log.info("{} {}", dateString,localDate);

        dateString = "Jun 5 2023";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        localDate = LocalDate.parse(dateString, dateTimeFormatter);
        log.info("{} {}", dateString,localDate);

        dateString = "Jun 05 2023";
        dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        localDate = LocalDate.parse(dateString, dateTimeFormatter);
        log.info("{} {}", dateString,localDate);
    }

    public void demonstrateFormatting() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

        LocalDateTime leaving = LocalDateTime.of(2023, Month.JUNE, 5, 11, 5);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        String formatedDeparture = departure.format(format);
        log.info("LEAVING: {} ({})", formatedDeparture, leavingZone);

        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(650);
        String formatedArrival = arrival.format(format);
        log.info("ARRAYING: {} ({})", formatedArrival, arrivingZone);

        if(arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {
            log.info("({} daylight saving time will be in effect.)", arrivingZone);
        } else {
            log.info("({} standard time will be in effect.)", arrivingZone);
        }
    }

    public void demonstrateChronoField() {
        ChronoField chronoField = ChronoField.CLOCK_HOUR_OF_DAY;
        boolean isSupported = LocalDate.now().isSupported(chronoField);
        log.info("LocalDate support {} ? {}", chronoField, isSupported);

        chronoField = ChronoField.DAY_OF_MONTH;
        isSupported = LocalDate.now().isSupported(ChronoField.DAY_OF_MONTH);
        log.info("LocalDate support {} ? {}", chronoField, isSupported);

        chronoField = ChronoField.MILLI_OF_SECOND;
        isSupported = LocalDate.now().isSupported(ChronoField.MILLI_OF_SECOND);
        log.info("LocalDate support {} ? {}", chronoField, isSupported);

        chronoField = ChronoField.MILLI_OF_SECOND;
        LocalTime localTime = LocalTime.now();
        int value = localTime.get(chronoField);
        log.info("LocalTime.now {} is {}", chronoField, value);

        TemporalField temporalField  = IsoFields.QUARTER_OF_YEAR;
        LocalDate localDate = LocalDate.now();
        value = localDate.get(temporalField);
        log.info("LocalDate.now {} is {}", temporalField, value);
    }

    public void demonstrateChronoUnit() {
        Instant instantNow = Instant.now();
        ChronoUnit chronoUnit = ChronoUnit.DECADES;
        boolean isSupported = instantNow.isSupported(chronoUnit);
        log.info("Instant support {} ? {}", chronoUnit, isSupported);

    }
    
    public void demonstrateTemporalAdjuster() {
        LocalDate localDate = LocalDate.of(2023, Month.JUNE, 5);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        log.info("{} is on a {}", localDate, dayOfWeek);

        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstDayOfMonth();
        LocalDate adjustedLocalDate =  localDate.with(temporalAdjuster);
        log.info("first Day Of Month : {}", adjustedLocalDate);


        temporalAdjuster = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        adjustedLocalDate =  localDate.with(temporalAdjuster);
        log.info("first monday Of Month : {}", adjustedLocalDate);

        temporalAdjuster = TemporalAdjusters.lastDayOfMonth();
        adjustedLocalDate = localDate.with(temporalAdjuster);
        log.info("last day Of Month : {}", adjustedLocalDate);

        temporalAdjuster = TemporalAdjusters.firstDayOfNextMonth();
        adjustedLocalDate = localDate.with(temporalAdjuster);
        log.info("first day Of next Month : {}", adjustedLocalDate);

        temporalAdjuster = TemporalAdjusters.firstDayOfYear();
        adjustedLocalDate = localDate.with(temporalAdjuster);
        log.info("first day Of year : {}", adjustedLocalDate);

        //
        localDate = LocalDate.of(2023, Month.OCTOBER, 15);
        dayOfWeek = localDate.getDayOfWeek();
        log.info("{} is on a {}", localDate, dayOfWeek);

        temporalAdjuster = TemporalAdjusters.firstDayOfMonth();
        adjustedLocalDate =  localDate.with(temporalAdjuster);
        log.info("first Day Of Month : {}", adjustedLocalDate);


        temporalAdjuster = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        adjustedLocalDate =  localDate.with(temporalAdjuster);
        log.info("first monday Of Month : {}", adjustedLocalDate);

        temporalAdjuster = TemporalAdjusters.lastDayOfMonth();
        adjustedLocalDate = localDate.with(temporalAdjuster);
        log.info("last day Of Month : {}", adjustedLocalDate);

        temporalAdjuster = TemporalAdjusters.firstDayOfNextMonth();
        adjustedLocalDate = localDate.with(temporalAdjuster);
        log.info("first day Of next Month : {}", adjustedLocalDate);

        temporalAdjuster = TemporalAdjusters.firstDayOfYear();
        adjustedLocalDate = localDate.with(temporalAdjuster);
        log.info("first day Of year : {}", adjustedLocalDate);
    }

    public void demonstrateCustomAdjusters() {
        LocalDate now = LocalDate.of(2023, Month.JUNE, 3);
        LocalDate nextPayDay = now.with(new PayDayAdjuster());
        log.info("Date is: {}, Next pay day: {} ({})", now, nextPayDay, nextPayDay.getDayOfWeek());

        now = LocalDate.of(2023, Month.JUNE, 18);
        nextPayDay = now.with(new PayDayAdjuster());
        log.info("Date is: {}, Next pay day: {} ({})", now, nextPayDay, nextPayDay.getDayOfWeek());
    }

    static class PayDayAdjuster implements TemporalAdjuster {

        @Override
        public Temporal adjustInto(Temporal temporal) {
            LocalDate date = LocalDate.from(temporal);
            int day;
            if(date.getDayOfMonth() < 15) {
                day = 15;
            } else {
                day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
            }

            date = date.withDayOfMonth(day);
            if(date.getDayOfWeek() == DayOfWeek.SATURDAY || 
                date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            }
            return temporal.with(date);
        }
        
    }

    public void demonstrateTemporalQueryPredefinedQueries() {
        TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
        log.info("LocalDate precision is: {}", LocalDate.now().query(query));
        log.info("LocalDateTime precision is: {}", LocalDateTime.now().query(query));
        log.info("Year precision is: {}", Year.now().query(query));
        log.info("YearMonth precision is: {}", YearMonth.now().query(query));
        log.info("Instant precision is: {}", Instant.now().query(query));
    }

    public void demonstrateTemporalQueryCustomQueries() {

        if ( CheckDate.checkDateForFamilyBirthDaysAndVacations(1, 24)) {
            log.info("{} is an important date!",LocalDate.of(Year.now().getValue(), 1, 24) );
        } else {
            log.info("{} is not an important date!",LocalDate.of(Year.now().getValue(), 1, 24) );
        } 

        LocalDate date = LocalDate.of(2024, Month.JANUARY, 24);
        if ( CheckDate.checkDateForFamilyBirthDaysAndVacations(date)) {
            log.info("{} is an important date!",LocalDate.of(Year.now().getValue(), 1, 24) );
        } else {
            log.info("{} is not an important date!",LocalDate.of(Year.now().getValue(), 1, 24) );
        } 

        date = LocalDate.of(2024, Month.AUGUST, 24);
        if ( CheckDate.checkDateForFamilyBirthDaysAndVacations(date)) {
            log.info("{} is an important date!",LocalDate.of(Year.now().getValue(), 1, 24) );
        } else {
            log.info("{} is not an important date!",LocalDate.of(Year.now().getValue(), 1, 24) );
        } 
    }

    public void demonstratePeriodAndDuration() {
        Instant t1 = Instant.now();
        Instant t2 = t1.plus(20L, ChronoUnit.SECONDS);
        Duration duration = Duration.between(t1, t2);
        long ns = duration.toNanos();
        log.info("Duration between {} and {} : {} (ns)", t1, t2, ns);
        ns = duration.toMillis();
        log.info("Duration between {} and {} : {} (ms)", t1, t2, ns);

        Instant start = Instant.now();
        Duration duraionGap = Duration.ofSeconds(19);
        Instant later =  start.plus(duraionGap);
        log.info("start: {}, later: {}", start, later);

        Instant previous, current;
        long gap;
        current = Instant.now();
        previous = current.minus(10, ChronoUnit.MINUTES);
        gap = ChronoUnit.MILLIS.between(previous, current);
        log.info("current: {}, previous: {}, gap: {} millis", current, previous, gap);

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1977, Month.JANUARY, 22);
        Period period = Period.between(birthday, today);
        long days = ChronoUnit.DAYS.between(birthday, today);
        log.info("I am {} years, {} months, and {} days old. ({} days total) ", period.getYears(), period.getMonths(), period.getDays(), days);

        today = LocalDate.now();
        birthday = LocalDate.of(1977, Month.JANUARY, 22);
        LocalDate nextBirthDay = birthday.withYear(today.getYear());
        if (nextBirthDay.isBefore(today) || nextBirthDay.isEqual(today)) {
            nextBirthDay.plusYears(1);
        }
        period  = Period.between(nextBirthDay, today);
        days = ChronoUnit.DAYS.between(nextBirthDay, today);
        log.info("There are {} months, and {} days until my next birthday. ({} days total) ", period.getMonths(), period.getDays(), days);
    }

    public void demonstrateNonISODateConversion() {
        LocalDateTime    today  = LocalDateTime.now();
        LocalDateTime    date   = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        JapaneseDate     jToday = JapaneseDate.from(today);
        JapaneseDate     jDate  = JapaneseDate.from(date);
        log.info("ISO: {}, JapaneseDate {}", today, jToday);
        log.info("ISO: {}, JapaneseDate {}", date, jDate);
        log.info("");
        HijrahDate       hToday = HijrahDate.from(today);
        HijrahDate       hDate  = HijrahDate.from(date);
        log.info("ISO: {}, HijrahDate {}", today, hToday);
        log.info("ISO: {}, HijrahDate {}", date, hDate);
        log.info("");
        MinguoDate       mToday = MinguoDate.from(today);
        MinguoDate       mDate  = MinguoDate.from(date);
        log.info("ISO: {}, MinguoDate {}", today, mToday);
        log.info("ISO: {}, MinguoDate {}", date, mDate);
        log.info("");
        ThaiBuddhistDate tToday = ThaiBuddhistDate.from(today);
        ThaiBuddhistDate tDate  = ThaiBuddhistDate.from(date);
        log.info("ISO: {}, ThaiBuddhistDate {}", today, tToday);
        log.info("ISO: {}, ThaiBuddhistDate {}", date, tDate);
        log.info("");

        LocalDate localDate = LocalDate.of(1996, Month.OCTOBER, 29);
        log.info("{}: {} (JapaneseChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, JapaneseChronology.INSTANCE));
        log.info("{}: {} (MinguoChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, MinguoChronology.INSTANCE));
        log.info("{}: {} (ThaiBuddhistChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, ThaiBuddhistChronology.INSTANCE));
        log.info("{}: {} (HijrahChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, HijrahChronology.INSTANCE));

        localDate = LocalDate.now();
        log.info("{}: {} (JapaneseChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, JapaneseChronology.INSTANCE));
        log.info("{}: {} (MinguoChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, MinguoChronology.INSTANCE));
        log.info("{}: {} (ThaiBuddhistChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, ThaiBuddhistChronology.INSTANCE));
        log.info("{}: {} (HijrahChronology)", localDate, ChronoLocalDateConverter.toChronoLocalDateString(localDate, HijrahChronology.INSTANCE));

        localDate = LocalDate.from(JapaneseDate.now());

        String dateString = "10/29/0008 H";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, JapaneseChronology.INSTANCE));
        dateString = "10/29/0085 1";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, MinguoChronology.INSTANCE));
        dateString = "10/29/0039 B.E.";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, ThaiBuddhistChronology.INSTANCE));
        dateString = "6/16/1417 1";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, HijrahChronology.INSTANCE));


        dateString = "6/7/05 R";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, JapaneseChronology.INSTANCE));
        dateString = "6/7/112 1";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, MinguoChronology.INSTANCE));
        dateString = "6/7/2566 B.E.";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, ThaiBuddhistChronology.INSTANCE));
        dateString = "11/18/1444 1";
        log.info("{}: {} ", dateString, ChronoLocalDateConverter.fromChronoLocalDateString(dateString, HijrahChronology.INSTANCE));
    }

    public void demonstrateCustomeDateTimeFormatPatterns() {
        LocalDate date = LocalDate.of(2023, Month.JUNE, 7);

        String pattern = "M/d/yyyy";
        log.info("{}: {}", pattern, format(date, pattern));

        pattern = "MM/dd/yyyy";
        log.info("{}: {}", pattern, format(date, pattern));

        pattern = "MMM  dd, yyyy";
        log.info("{}: {}", pattern, format(date, pattern));

        pattern = "MMMM  dd,  yyyy";
        log.info("{}: {}", pattern, format(date, pattern));

        pattern = "EEEE, MMMM  dd,  yyyy";
        log.info("{}: {}", pattern, format(date, pattern));

        pattern = "'Month' q 'in' QQQ";
        log.info("{}: {}", pattern, format(date, pattern));
    }

    public static void main(String[] args) {
        BasicDateTimeDemo demo = new BasicDateTimeDemo();
        demo.demonstrateLocalDateWithTemporalAdjusters();
        demo.demonstrateLocalDateWithPlusYears();
        demo.demonstrateDayOfWeekEnumWithMethods();
        demo.demonstrateMonthEnumWithMetodes();
        demo.demonstrateLocalDate();
        demo.demonstrateYearMonth();
        demo.demonstrateMonthDay();
        demo.demonstrateYear();
        demo.demonstradeLocalTime();
        demo.demonstradeLocalDateTime();
        demo.demonstrateZoneIdAndZoneOffset();
        demo.demonstrateZonedDateTime();
        demo.demonstrateOffsetDateTime();
        demo.demonstrateOffsetTime();
        demo.demonstrateInstant();
        demo.demonstrateParsing();
        demo.demonstrateFormatting();
        demo.demonstrateChronoField();
        demo.demonstrateChronoUnit();
        demo.demonstrateTemporalAdjuster();
        demo.demonstrateCustomAdjusters();
        demo.demonstrateTemporalQueryPredefinedQueries();
        demo.demonstrateTemporalQueryCustomQueries();
        demo.demonstratePeriodAndDuration();
        demo.demonstrateNonISODateConversion();
        demo.demonstrateCustomeDateTimeFormatPatterns();
    }
}
