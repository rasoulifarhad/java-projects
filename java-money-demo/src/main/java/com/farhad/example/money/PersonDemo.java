package com.farhad.example.money;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.farhad.example.money.Person.CheckPerson;
import com.farhad.example.money.Person.Sex;

public class PersonDemo {
    
    public static void main(String[] args) {
    
        List<Person> people = Person.createRoster();

        filterAndLogPeopleOlderThan(people, 30);
        filterAndLogPeopleBetweenAges(people, 30, 40);
        filterAndLogPeople(people, new CheckPerson() {

            @Override
            public boolean test(Person person) {
                return person.getGender() == Sex.MALE 
                        && person.getAge() >= 18 
                        && person.getAge() <= 25;
            }
        });

        filterAndLogPeople(people, person -> 
                person.getGender() == Sex.MALE && 
                person.getAge() >= 18 &&
                person.getAge() <= 25);

        filterAndLogPeopleWithPredicate(people, person -> 
                person.getGender() == Sex.MALE && 
                person.getAge() >= 18 &&
                person.getAge() <= 25);
    }

    private static void filterAndLogPeopleOlderThan(List<Person> people, int age) {
        for(Person person : people) {
            if ( person.getAge() >= age) {
                person.printPerson();
            }
        }
    }

    private static void filterAndLogPeopleBetweenAges(List<Person> people, int from, int to) {
        for(Person p : people) {
            if(p.getAge() >= from && p.getAge() < to) {
                p.printPerson();
            }
        }
    }

    private static void filterAndLogPeople(List<Person> people, CheckPerson tester) {
        for (Person p : people) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }

    private static void filterAndLogPeopleWithPredicate(List<Person> people, Predicate<Person> tester) {
        for(Person p : people) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }

    private static void  filterAndConsumePeople(List<Person> people, Predicate<Person> tester, Consumer<Person> consumer) {
        for(Person p : people) {
            if (tester.test(p)) {
                consumer.accept(p);
            }
        }
    }

    private static void  filterAndProcessThenConsumePeople(List<Person> people, 
                                                            Predicate<Person> tester, 
                                                            Function<Person, String> mapper,
                                                            Consumer<String> consumer) {
        for(Person p : people) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                consumer.accept(data);
            }
        }
    }

    private static <X, Y> void processElements(Iterable<X> source,
                                          Predicate<X> tester,
                                          Function<X, Y> mapper,
                                          Consumer<Y> consumer) {
        for(X x : source) {
            if(tester.test(x)) {
                Y data = mapper.apply(x);
                consumer.accept(data);
            }
        }
    }

}

