package com.farhad.example.enums;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class EnumDemo {
    
    Day day;

    public void tellAboutDay() {
        switch (day) {
            case SUNDAY:
                log.info("Sunday is baddd!");
                break;
            case WEDNESDAY:
                log.info("wendensday is better.");
                break;
            case THURSDAY: case FRIDAY: 
                log.info("Weekends are best.");
                break;
            default:
                log.info("Midweek is so-so.");
                break;
        }
    }

    public static void main(String[] args) {
        EnumDemo fistDayOfWeek = new EnumDemo(Day.SUNDAY);
        fistDayOfWeek.tellAboutDay();

        EnumDemo beforeWeekendsDay = new EnumDemo(Day.WEDNESDAY);
        beforeWeekendsDay.tellAboutDay();

        EnumDemo weekendsDsay = new EnumDemo(Day.THURSDAY);
        weekendsDsay.tellAboutDay();
        weekendsDsay = new EnumDemo(Day.FRIDAY);
        weekendsDsay.tellAboutDay();

        EnumDemo midweekDay = new EnumDemo(Day.MONDAY);
        midweekDay.tellAboutDay();
    }
}
