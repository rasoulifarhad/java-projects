package com.farhad.example.datetime;

import java.time.LocalDate;
import java.time.Year;

public class CheckDate {
    
    public static Boolean checkDateForFamilyBirthDaysAndVacations(int month, int day) {
        
        LocalDate date = LocalDate.of(Year.now().getValue(), month, day);
        Boolean isVacation = date.query(new Vacations());
        Boolean isFamilyBirthday = date.query(FamilyBirthdays::isFamilyBirthday);
        return isVacation.booleanValue() || isFamilyBirthday.booleanValue() ;
    }
    public static Boolean checkDateForFamilyBirthDaysAndVacations(LocalDate date) { 
        
        Boolean isVacation = date.query(new Vacations());
        Boolean isFamilyBirthday = date.query(FamilyBirthdays::isFamilyBirthday);
        return isVacation.booleanValue() || isFamilyBirthday.booleanValue() ;
    }

}
