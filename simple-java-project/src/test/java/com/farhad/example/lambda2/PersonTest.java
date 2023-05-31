package com.farhad.example.lambda2;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * See https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
@Slf4j
public class PersonTest {
    
    private List<Person> roster;

    @BeforeEach
    public void setup() {
        roster = Person.createRoster();
    }

    @AfterEach
    public void tearDown() {
        roster = null;
    }

    @Test
    public void printAllPersonsTest() {
        Person.printPersons(roster);
    }

    @Test
    public void printPersonOlderThanTest() {
        Person.printPersonOlderThan(roster, 18);
    }

    @Test 
    public void printPersonsWithinAgeRangeTest() {
        Person.printPersonsWithinAgeRange(roster, 18, 25);
    }

    @Test
    public void checkPersonEligibleForSelectiveServiceTest() {
        Person.printPersons(roster, new CheckPersonEligibleForSelectiveService());
    }

    @Test
    public void checkAllPersonTest() {
        Person.printPersons(roster, new CheckAllPerson());
    }

    @Test
    public void checkPersonEligibleForSelectiveServiceWithAnonymousClassTest() {
        Person.printPersons(roster, new CheckPerson() {

            @Override
            public boolean test(Person person) {
                return person.gender == Person.Sex.MALE && 
                person.getAge() >= 18 &&
                person.getAge() < 25 ;
            }
        });
    }

    @Test
    public void checkPersonEligibleForSelectiveServiceWithLambdaTest() {
        Person.printPersons(roster, person -> person.gender == Person.Sex.MALE &&
                                                     person.getAge() >= 18 &&
                                                     person.getAge() < 25);
    }

    @Test 
    public void printPersonsWithPredicateTest() {
        Person.printPersonsWithPredicate(roster, person -> person.gender == Person.Sex.MALE &&
                                                            person.getAge() >= 18 &&
                                                            person.getAge() < 25);
    }

    @Test
    public void checkPersonEligibleForSelectiveServiceWithLambdaAndConsumerTest() {
        Person.printPersons(roster, 
                            person -> person.gender == Person.Sex.MALE &&
                                        person.getAge() >= 18 &&
                                        person.getAge() < 25,
                            person -> person.printPerson());
    }

    @Test
    public void processPersonsWithFunctionTest() {
        Person.processPersonsWithFunction(roster, 
                                        person -> person.gender == Person.Sex.MALE &&
                                                    person.getAge() >= 18 &&
                                                    person.getAge() < 25,
                                        person -> person.getEmailAddress() ,
                                        email -> log.info("{}", email));
    }

    @Test
    public void processElementsTest() {
        Person.processElements(roster, 
                               person -> person.gender == Person.Sex.MALE &&
                                        person.getAge() >= 18 &&
                                        person.getAge() < 25,
                               person -> person.getEmailAddress() ,
                               email -> log.info("{}", email));
    }

    @Test
    public void processElementsUsingAggregateOperationsTest() {
        roster.stream()
                    .filter(
                        person -> person.gender == Person.Sex.MALE &&
                                    person.getAge() >= 18 &&
                                    person.getAge() < 25)
                    .map(person -> person.getEmailAddress())
                    .forEach(email -> log.info("{}", email));
    }

}
