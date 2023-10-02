package com.farhad.example.functional_interface;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Compare {
    
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));

        List<Person> ascendingAge = 
            people.stream()
                .sorted((p1, p2) -> p1.ageDifference(p2))
                .collect(toList());
        printPeople("Sorted in ascending order by age: ", ascendingAge);
        
        printPeople("Sorted in ascending order by age: ", 
            people.stream()
                .sorted((p1, p2) -> p2.ageDifference(p1))
                .collect(toList()));                
        
        Comparator<Person> compareAscending = (p1, p2) -> p1.ageDifference(p2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        printPeople("Sorted in ascending order by age: ", 
            people.stream()
                .sorted(compareAscending)
                .collect(toList()));                
        printPeople("Sorted in descending order by age:", 
            people.stream()
                .sorted(compareDescending)
                .collect(toList()));  
                
        printPeople("Sorted in ascending order by name: ",
            people.stream()
                .sorted((person1, person2) ->
                        person1.getName().compareTo(person2.getName()))
                .collect(toList()));                
        people.stream()
            .min(Person::ageDifference)
            .ifPresent(youngest -> System.out.println("youngest: " + youngest));
        people.stream()
            .max(Person::ageDifference)
            .ifPresent(eldest -> System.out.println("eldest: " + eldest));

        Function<Person, String> byName = person -> person.getName();
        Function<Person, Integer> byAge = person -> person.getAge();

        printPeople("Sorted in ascending order by age and name: ",
            people.stream()
                .sorted(Comparator.comparing(byAge).thenComparing(byName))
                .collect(toList()));
        List<Person> olderThan20 = new ArrayList<>();
        people.stream()
            .filter(person -> person.getAge() > 20)
            .forEach(person -> olderThan20.add(person));
        System.out.println("People older than 20: " + olderThan20);   
        List<Person> olderThan20_1 = 
            people.stream()
                .filter(person -> person.getAge() > 20 )
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("People older than 20: " + olderThan20);   

    }

    private static void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

    public static class Person {
        private final String name;
        private final int age;

        public Person(final String theName, final int theAge) {
            name = theName;
            age = theAge;
        }
        
        public String getName() { return name; }
        
        public int getAge() { return age; }
        
        public int ageDifference(final Person other) {
            return age - other.age;
        }

        public String toString() {
            return String.format("%s - %d", name, age);
        }
    }    
}
