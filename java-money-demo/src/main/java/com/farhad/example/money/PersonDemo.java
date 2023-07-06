package com.farhad.example.money;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import javax.money.MonetaryAmount;

import com.farhad.example.money.Person.CheckPerson;
import com.farhad.example.money.Person.Sex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonDemo {
    
    public static void main(String[] args) {
    
        List<Person> people = Person.createRoster();

        log.info("==================== filterAndLogPeopleOlderThan 30 ==========================");
        filterAndLogPeopleOlderThan(people, 30);
        log.info("==================== filterAndLogPeopleBetweenAges 30, 40 ==========================");
        filterAndLogPeopleBetweenAges(people, 30, 40);
        log.info("==================== filterAndLogPeople [MALE, age>=18, age<=25] ==========================");
        filterAndLogPeople(people, new CheckPerson() {

            @Override
            public boolean test(Person person) {
                return person.getGender() == Sex.MALE 
                        && person.getAge() >= 18 
                        && person.getAge() <= 25;
            }
        });

        log.info("==================== filterAndLogPeople [MALE, age>=18, age<=25] ==========================");
        filterAndLogPeople(people, new EligibleForSelectiveService());

        log.info("==================== filterAndLogPeople [MALE, age>=18, age<=25] ==========================");
        filterAndLogPeople(people, person -> 
                person.getGender() == Sex.MALE && 
                person.getAge() >= 18 &&
                person.getAge() <= 25);

        log.info("==================== filterAndLogPeopleWithPredicate [MALE, age>=18, age<=25] ==========================");
        filterAndLogPeopleWithPredicate(people, person -> 
                person.getGender() == Sex.MALE && 
                person.getAge() >= 18 &&
                person.getAge() <= 25);

        log.info("==================== filterAndConsumePeople [MALE, age>=18, age<=25] ==========================");
        filterAndConsumePeople(people, 
                                p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, 
                                p -> p.printPerson());

        log.info("==================== filterAndProcessThenConsumePeople [MALE, age>=18, age<=25] ==========================");
        filterAndProcessThenConsumePeople(people, 
                                    p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, 
                                    p -> p.getEmailAddress(), 
                                    email -> log.info("{}", email) );      

        log.info("===================== WithStream [MALE, age>=18, age<=25, salary<=100000] =========================");
        people.stream()
            .filter(p -> 
                p.getGender() == Sex.MALE && 
                p.getAge() >= 18 && p.getAge() <= 25 
                && p.getSalary().getNumber().intValue() <= 100000 )
            .map(p -> p.getSalary())
            .forEach(salary -> log.info("{}", salary));

        log.info("================== filterAndConsumeWithOpoerator [MALE, age>=18, age<=25] ============================");
        filterAndConsumeWithOpoerator(people,
                                    p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                                    m -> m,
                                    salary -> log.info("{}", salary));
            
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

    public static <X, Y> void processElements(Iterable<X> source,
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

    private static void filterAndConsumeWithOpoerator(List<Person> people,
                                                    Predicate<Person> tester,
                                                    UnaryOperator<MonetaryAmount> mapper,
                                                    Consumer<MonetaryAmount> consumer) {

        for(Person p : people) {
            if (tester.test(p)) {
                MonetaryAmount data = mapper.apply(p.getSalary());
                consumer.accept(data);
            }
        }
    }

    public static class EligibleForSelectiveService implements CheckPerson {

        @Override
        public boolean test(Person person) {
            return 
                person.getGender() == Sex.MALE && 
                person.getAge() >= 18 &&
                person.getAge() <= 25;
        }
    }

}

