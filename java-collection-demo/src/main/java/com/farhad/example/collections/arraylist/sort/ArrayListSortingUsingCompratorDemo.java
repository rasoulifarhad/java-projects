package com.farhad.example.collections.arraylist.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class ArrayListSortingUsingCompratorDemo {
    
    @Data
    @NoArgsConstructor
    public static class Person {
        private int id;
        private String firstName ;
        private String lastName ;
        private String gender;
        // private Date  birthDate;
        private int age;

        public String getName(){
            return lastName + ' ' + firstName;
        }

        public static Comparator<Person> compareByAge = new Comparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                return ( ( p1.getAge() < p2.getAge() ) ? -1 : ( p1.getAge() == p2.getAge() ? 0 : 1 ));
            }
        };

        public static Comparator<Person> compareByName = new Comparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
    }

    @RequiredArgsConstructor
    public static class PersonSorter {
        private final List<Person> persons ;

        public List<Person> sortByAge() {
            List<Person> clonedPapers = new ArrayList<>(this.persons);
            Collections.sort(clonedPapers, Person.compareByAge);
            return clonedPapers;
        }

        public List<Person> sortByName() {
            List<Person> clonedPapers = new ArrayList<>(this.persons);
            Collections.sort(clonedPapers, Person.compareByName);
            return clonedPapers;
        }
    }


}
