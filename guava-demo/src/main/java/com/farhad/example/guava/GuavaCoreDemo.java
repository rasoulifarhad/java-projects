package com.farhad.example.guava;

import static com.google.common.base.MoreObjects.firstNonNull;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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

    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    static class Customer {
        private final Long id;
        private final String name;
        private boolean sick;
        private String address;
    }

    @Data
    static class Ingredients {

    }

    @Data
    static class IngredientsFactory implements Supplier<Ingredients> {

        private int numberOfIngredientsUsed = 0;
        
        @Override
        public Ingredients get() {
            numberOfIngredientsUsed++;
            return new Ingredients();
        }

    }

    @Data
    @RequiredArgsConstructor
    static class Cake {
        private final Ingredients ingredients;
    }

    // private Function<Ingredients, Cake> bake() {
    //     return new Function<Ingredients,Cake>() {

    //         @Override
    //         public Cake apply(Ingredients ingredients) {
    //             return new Cake(ingredients);
    //         }
    //     };
    // }

    static class Coordinates {
        private static final String UNKNOWN_COORDINATES = "Unknown coordinates";

        public String getCoordinatesAsText() {
            // return getGpsCoordinates() != null ? getGpsCoordinates() : UNKNOWN_COORDINATES; 
            
            // String gpsCoordinates = getGpsCoordinates();
            // return gpsCoordinates != null ? gpsCoordinates : UNKNOWN_COORDINATES;

            return firstNonNull(getGpsCoordinates(), UNKNOWN_COORDINATES );
        }

        public String getGpsCoordinates() {
            // retrieve GPS Coordinates from satellite
            try {
                Thread.sleep(20000);
                return "48.857438,2.352221";// return DMC 48 51 23.81,2 21 7.995
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interupted", e);
            }
        }
    }
    
}
