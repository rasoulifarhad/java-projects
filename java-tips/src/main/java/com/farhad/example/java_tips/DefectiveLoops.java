package com.farhad.example.java_tips;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class DefectiveLoops {

    public static void main(String[] args) {
        new DefectiveLoops().demo();
    }

    private void demo() {

        var people = List.of(
            new Person("state#1", "city#1", "name #100"),
            new Person("state#1", "city#2", "name #110"),
            new Person("state#2", "city#3", "name #120"),
            new Person("state#3", "city#1", "name #130")
        );
        var peopleByStateAndCity = new HashMap<String, Map<String, List<Person>>>();

        for (Person person : people) {
            peopleByStateAndCity
                .computeIfAbsent(person.getState(), state -> new HashMap<>())
                .computeIfAbsent(person.getCity(), city -> new ArrayList<>())
                .add(person);
        }

        System.out.println("People by state && city:" + peopleByStateAndCity);
    }

    @Getter
    @RequiredArgsConstructor
    static class  Person {
        
        private final String state;
        private final String city;
        private final String name;

        @Override
        public String toString() {
            return String.format("Person{%s, %s, %s}",state, city, name);
        }

        
    }
}

