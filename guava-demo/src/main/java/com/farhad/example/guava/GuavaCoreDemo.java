package com.farhad.example.guava;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaCoreDemo {
    
    public void demonstrateFilterCollectionByCustomPredicate() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5);
        Predicate<Integer> acceptEven = new Predicate<Integer>() {

            @Override
            public boolean apply(Integer number) {
                return (number % 2) == 0;
            }
        };
        List<Integer> evenNumbers = Lists.newArrayList( Collections2.filter(numbers, acceptEven));
        int found = Collections.binarySearch(evenNumbers, 3);
        log.info("element {} found? {}", 3, found);
    }

    public static void main(String[] args) {
        
        GuavaCoreDemo demo = new GuavaCoreDemo();
        demo.demonstrateFilterCollectionByCustomPredicate();
    }

    @Data
    @Builder
    static class Person {
        private final String name;
        private String nickname;

        public Optional<String> getNickname() {
            return Optional.fromNullable(nickname);
        }
    }
}
