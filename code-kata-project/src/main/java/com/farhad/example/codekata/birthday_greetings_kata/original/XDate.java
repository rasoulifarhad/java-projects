package com.farhad.example.codekata.birthday_greetings_kata.original;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class XDate {
    private Date date;

    public XDate() {
        date = new Date();
    }

    public XDate(String yyyyMMdd) throws ParseException {
        date = new SimpleDateFormat("yyyy/MM/dd").parse(yyyyMMdd);
    }

    public int getDay() {
        return getPartOfDate(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        return 1 + getPartOfDate(GregorianCalendar.MONTH);
    }

    public boolean isSameDay(XDate anotherDate) {
        return anotherDate.getDay() == this.getDay() && anotherDate.getMonth() == this.getMonth();
    }
    private int getPartOfDate(int part) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(part);
	}    
}
