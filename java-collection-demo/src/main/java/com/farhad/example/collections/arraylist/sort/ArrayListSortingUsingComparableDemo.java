package com.farhad.example.collections.arraylist.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayListSortingUsingComparableDemo {
    
    @Data
    @NoArgsConstructor
    public static class Person implements Comparable<Person> {
        private int id;
        private String firstName ;
        private String lastName ;
        private String gender;
        // private Date  birthDate;
        private int age;

        @Override
        public int compareTo(Person o) {
            return ( ( this.getAge() < o.getAge() ) ? -1 : ( this.getAge() == o.getAge() ? 0 : 1 ));
        }
    }

    @RequiredArgsConstructor
    public static class PersonSorter {
        private final List<Person> persons ;

        public List<Person> sortByAge() {
            List<Person> clonedPapers = new ArrayList<>(this.persons);
            Collections.sort(clonedPapers);
            return clonedPapers;
        }
    }

    public static void main(String[] args) {
        log.info("");
    }
}
