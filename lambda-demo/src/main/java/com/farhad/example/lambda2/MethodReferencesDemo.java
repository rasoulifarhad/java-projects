package com.farhad.example.lambda2;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MethodReferencesDemo {
    

    public void demonstratePersonSortWithoutMethodReference() {
        List<Person> roster = Person.createRoster();
        log.info("UnSorted persons:");
        roster.stream().forEach(person -> person.printPerson());
        Person [] rosterAsArray = roster.toArray(new Person[roster.size()]);

        Arrays.sort(rosterAsArray, new PersonAgeComparator());
        log.info("Sorted persons without( MethodReference):");
        Arrays.asList(rosterAsArray).stream().forEach(p ->  p.printPerson());
        // log.info("{}", Arrays.asList(rosterAsArray));
    } 

    public void demonstratePersonSortWithLambdaExpression() {
        List <Person> roster = Person.createRoster();
        log.info("UnSorted persons:");
        roster.stream().forEach(person -> person.printPerson());
        Person [] rosterAsArray = roster.toArray(new Person[roster.size()]);

        Arrays.sort(rosterAsArray, 
                     (p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday()) );
        log.info("Sorted persons with (Lambda Expression):");
        Arrays.asList(rosterAsArray).stream().forEach(p ->  p.printPerson());
        // log.info("{}", Arrays.asList(rosterAsArray));
    }

    public void demonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson() {
        List <Person> roster = Person.createRoster();
        log.info("UnSorted persons:");
        roster.stream().forEach(person -> person.printPerson());
        Person [] rosterAsArray = roster.toArray(new Person[roster.size()]);

        Arrays.sort(rosterAsArray, 
                     (p1, p2) -> Person.compareByAge(p1, p2) );
        log.info("Sorted persons with (Lambda Expression And CompareByAge Method Of Person):");
        Arrays.asList(rosterAsArray).stream().forEach(p ->  p.printPerson());
        // log.info("{}", Arrays.asList(rosterAsArray));
    }

    public void demonstratePersonSortWithMethodReference() {
        List <Person> roster = Person.createRoster();
        log.info("UnSorted persons:");
        roster.stream().forEach(person -> person.printPerson());
        Person [] rosterAsArray = roster.toArray(new Person[roster.size()]);

        Arrays.sort(rosterAsArray, Person::compareByAge);
        log.info("Sorted persons with (Method Reference):");
        Arrays.asList(rosterAsArray).stream().forEach(p ->  p.printPerson());
        // log.info("{}", Arrays.asList(rosterAsArray));
    }

    public static void main(String[] args) {
        
        MethodReferencesDemo demo = new MethodReferencesDemo();
        demo.demonstratePersonSortWithoutMethodReference();
        demo.demonstratePersonSortWithLambdaExpression();
        demo.demonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson();
        demo.demonstratePersonSortWithMethodReference();

        
    }
}
