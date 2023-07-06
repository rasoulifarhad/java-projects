package com.farhad.example.money;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.List;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;

@Data
@RequiredArgsConstructor
public  class Person {

    public static interface CheckPerson {
        boolean test(Person person);
    }
    
    public enum Sex {
        MALE, FEMALE
    }

    final String name; 
    final LocalDate birthday;
    final Sex gender;
    final String emailAddress;
    final MonetaryAmount salary;

    public int getAge() {
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public void printPerson() {
        System.out.println(String.format("%s, %s",name, getAge()));
    }

    public static int compareByAge(Person p1, Person p2) {
        return p1.birthday.compareTo(p2.birthday);
    }

    public static int compareBySalary(Person p1, Person p2) {
        return p1.salary.compareTo(p2.salary);
    }

    public static List<Person> createRoster() {
        Faker faker = new Faker();
        
        // final List<Person> roster = new ArrayList<>();
        
        // roster.add( new Person(
        //     "Fred", 
        //     IsoChronology.INSTANCE.date(1980, 6, 20), 
        //     Sex.MALE, 
        //     "fred@example.com", 
        //     Money.of(100000, "USD")));

        // roster.add( new Person(
        //     "Jane", 
        //     IsoChronology.INSTANCE.date(1990, 7, 15), 
        //     Sex.FEMALE, 
        //     "jane@example.com", 
        //     Money.of(80000, "USD")));
        
        // roster.add( new Person(
        //     "George", 
        //     IsoChronology.INSTANCE.date(1991, 8, 13), 
        //     Sex.MALE, 
        //     "george@example.com", 
        //     Money.of(70000, "USD")));
        
        // roster.add( new Person(
        //     "Bob", 
        //     IsoChronology.INSTANCE.date(2000, 9, 12), 
        //     Sex.MALE, 
        //     "bob@example.com", 
        //     Money.of(25000, "USD")));

        final List<Person> roster = faker.collection(
            () -> new Person(
                            faker.name().fullName(), 
                            faker.date().birthday(20, 60).toLocalDateTime().toLocalDate(), 
                            Sex.valueOf(faker.expression("#{options.option 'MALE','FEMALE'")), 
                                faker.internet().emailAddress(), 
                            Money.of(faker.number().numberBetween(90000, 120000), "USD")))
            .len(4)
            .generate();
            
        return roster;
    }
}
