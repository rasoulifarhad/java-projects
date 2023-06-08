package com.farhad.example.lambda2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import com.farhad.example.lambda2.Person.ComparisonProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MethodReferencesDemo {
    
    public static <T, S extends Collection<T>, D extends Collection<T>>  D transferElements(S source, Supplier<D> factory) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(factory);
        D res =  factory.get();
        for (T t : source) {
            res.add(t);
        }
        return res;
    }

    public static String staticAppendStrings(String str1, String str2) {
        return str1 + str2;
    }

    public String appendStrings(String str1, String str2) {
        return str1 + str2;
    }

    /**
     * The BiFunction functional interface can represent a lambda expression or method reference that accepts two arguments and produces a result.
     */
    public static <T> T mergeThings(T t1, T t2, BiFunction<T, T, T> merger ) {
        return merger.apply(t1, t2);
    }

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

    public void demonstrateDiferentMethodReferenceUsageWithMergeThings() {
        String fullName = mergeThings("Farhad ", "Rasouli", (s1, s2) ->  s1 + s2);
        log.info("{}", fullName);

        fullName = mergeThings("Farhad ", "Rasouli", MethodReferencesDemo::staticAppendStrings);
        log.info("{}", fullName);

        fullName = mergeThings("Farhad ", "Rasouli", this::appendStrings);
        log.info("{}", fullName);

        fullName = mergeThings("Farhad ", "Rasouli", String::concat);
        log.info("{}", fullName);
    }

    public void demonstrateReferenceToAnInstanceMethodOfParticularObject() {
        ComparisonProvider comparisonProvider = Person.getComparisonProvider();
        List <Person> roster = Person.createRoster();
        Person [] rosterAsArray = roster.toArray(new Person[roster.size()]);
        log.info("UnSorted persons: {}{}", "", rosterAsArray);

        Arrays.sort(rosterAsArray, comparisonProvider::compareByName);
        log.info("Sorted persons based with Name with (Method Reference): {}{}", "", rosterAsArray);
    }


    public void demonstrateReferenceToAnInstanceMethodOfAnArbitraryObjectOfParticularType() {
        String[] stringArray = { "Barbara", "James", "Mary", "John","Patricia", "Robert", "Michael", "Linda" };
        log.info("UnSorted: {}{}","", stringArray) ;

        // The equivalent lambda expression for the method reference String::compareToIgnoreCase would have the formal parameter list 
        // (String a, String b), where a and b are arbitrary names used to better describe this example. The method reference would 
        // invoke the method a.compareToIgnoreCase(b).
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        log.info("Sorted: {}{}","", stringArray) ;
    }

    public void demonstrateReferenceToConstructor() {
        List<Person> roster = Person.createRoster();
        // with lambda
        Set<Person> rosterSet = transferElements(roster, () -> {
                                                        return new HashSet<>();
                                                    });
        log.info("{}", rosterSet);

        // with Reference to a Constructor
        rosterSet = transferElements(roster, HashSet::new);
        log.info("{}", rosterSet);

        rosterSet = transferElements(roster, HashSet<Person>::new);
        log.info("{}", rosterSet);
    }

    public static void main(String[] args) {
        
        MethodReferencesDemo demo = new MethodReferencesDemo();
        demo.demonstratePersonSortWithoutMethodReference();
        demo.demonstratePersonSortWithLambdaExpression();
        demo.demonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson();
        demo.demonstratePersonSortWithMethodReference();
        demo.demonstrateDiferentMethodReferenceUsageWithMergeThings();
        demo.demonstrateReferenceToAnInstanceMethodOfParticularObject();
        demo.demonstrateReferenceToAnInstanceMethodOfAnArbitraryObjectOfParticularType();
        demo.demonstrateReferenceToConstructor();
    }
}
