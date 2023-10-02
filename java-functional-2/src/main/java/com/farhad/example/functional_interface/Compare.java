package com.farhad.example.functional_interface;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
