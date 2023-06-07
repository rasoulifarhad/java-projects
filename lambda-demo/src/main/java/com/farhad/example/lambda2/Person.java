package com.farhad.example.lambda2;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Person {
    
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return Period.between(birthday, LocalDate.now())
                    .getYears();
        // return birthday
        //             .until(LocalDate.now())
        //             .getYears();
        // return birthday
        //             .until(IsoChronology.INSTANCE.dateNow())
        //             .getYears();
    }
    public void printPerson() {
        log.info("{}", toString());
    }

    public static void printPersons(List<Person> roster){
        for (Person person : roster) {
            person.printPerson();
        }
    }

    public static void printPersonOlderThan(List<Person> roster, int age) {
        for (Person person : roster) {
            if(person.getAge() >= age){
                person.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person person : roster) {
            if ( person.getAge() >= low && person.getAge() < high ) {
                person.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person person : roster) {
            if ( tester.test(person)) {
                person.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person person : roster) {
            if( tester.test(person) ) {
                person.printPerson();;
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester, Consumer<Person> consumer) {
        for (Person person : roster) {
            if ( tester.test(person)) {
                consumer.accept(person);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster, 
                                                  CheckPerson tester,
                                                  Function<Person,String> mapper,
                                                  Consumer<String> consumer) {
        for (Person person : roster) {
            if ( tester.test(person)) {
                String data = mapper.apply(person);
                consumer.accept(data);
            }
        }

    }

    public static <X,Y> void processElements(Iterable<X> source, 
                                            Predicate<X> tester,
                                            Function<X,Y> mapper,
                                            Consumer<Y> consumer) {
        for (X x : source) {
            if ( tester.test(x)) {
                Y data = mapper.apply(x);
                consumer.accept(data);
            }
        }

    }

    public static <X,Y> void processElementsLambda(List<X> source, 
                                            Predicate<X> tester,
                                            Function<X,Y> mapper,
                                            Consumer<Y> consumer) {
        source
            .stream()
            .filter(tester)
            .map(mapper)
            .forEach(consumer);
    }

    public static  int compareByAge(Person p1, Person p2) {
        return p1.getBirthday().compareTo(p2.getBirthday());
    }

    public static List<Person> createRoster() {
        
        List<Person> roster = new ArrayList<>();
         
        roster.add(
            new Person(
            "Fred",
            IsoChronology.INSTANCE.date(1990, 6, 20),
            Person.Sex.MALE,
            "fred@example.com"));
        roster.add(
            new Person(
            "Jane",
            IsoChronology.INSTANCE.date(1980, 7, 15),
            Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
            new Person(
            "George",
            IsoChronology.INSTANCE.date(1978, 8, 13),
            Person.Sex.MALE, "george@example.com"));
        roster.add(
            new Person(
            "Bob",
            IsoChronology.INSTANCE.date(2000, 9, 12),
            Person.Sex.MALE, "bob@example.com"));
        
        return roster;
    }

}
