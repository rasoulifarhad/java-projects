package com.farhad.example.collections.aggregate;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Person {
    
    public enum Sex {
        MALE,FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public int getAge() {
        return birthday.until(IsoChronology.INSTANCE.dateNow())
                        .getYears();
    }

    public void printPerson() {
        log.info("{}, {}",name, this.getAge());
    }

    public static int compareByAge(Person p1, Person p2) {
        return p1.getBirthday().compareTo(p2.getBirthday());
    }

    public static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();
        roster.add(
            new Person(
                "Fred", 
                IsoChronology.INSTANCE.date(1980, 6, 20), 
                Sex.MALE, 
                "fred@example.com"));
        roster.add(
            new Person(
                "Jane", 
                IsoChronology.INSTANCE.date(1990, 7, 15), 
                Sex.FEMALE, 
                "jane@example.com"));
        roster.add(
            new Person(
            "George",
            IsoChronology.INSTANCE.date(1991, 8, 13),
            Person.Sex.MALE, "george@example.com"));
        roster.add(
            new Person(
            "Bob",
            IsoChronology.INSTANCE.date(2000, 9, 12),
            Person.Sex.MALE, "bob@example.com"));
        return roster;
    }
}
