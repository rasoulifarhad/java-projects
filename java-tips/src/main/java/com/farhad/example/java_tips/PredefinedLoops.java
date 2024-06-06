package com.farhad.example.java_tips;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class PredefinedLoops {

    public static void main(String[] args) {
        new PredefinedLoops().demo();
    }

    private void demo() {

        var peopleStream = Stream.of(
                new Person("state#1", "city#1", "name #100"),
                new Person("state#1", "city#2", "name #110"),
                new Person("state#2", "city#3", "name #120"),
                new Person("state#3", "city#1", "name #130"));
        Map<String, Map<String, List<Person>>> peopleByStateAndCity = peopleStream
                .collect(groupingBy(Person::getState, groupingBy(Person::getCity)));

        System.out.println("People by state && city:" + peopleByStateAndCity);

    }

    @Getter
    @RequiredArgsConstructor
    static class Person {

        private final String state;
        private final String city;
        private final String name;

        @Override
        public String toString() {
            return String.format("Person{%s, %s, %s}", state, city, name);
        }
    }

}
