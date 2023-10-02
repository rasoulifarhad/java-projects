package com.farhad.example.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickDifferentNames {
    
    public static void main(String[] args) {
        
        final List<String> friends =
        Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors =
        Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades =
        Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");  

        final Predicate<String> startWithN = name -> name.startsWith("N");
        final Predicate<String> startWithB = name -> name.startsWith("B");
        final long countFriendsStartN = 
            friends.stream()
                    .filter(startWithN).count();
        final long countFriendsStartB = 
            friends.stream()
                    .filter(startWithB).count();

        final long countFriendsStartN2 = 
            friends.stream()
                    .filter(checkIfStartWith("N")).count();
        final long countFriendsStartB2 = 
            friends.stream()
                    .filter(checkIfStartWith("B")).count();

        final Function<String, Predicate<String>> startsWithLetter =
            letter -> name -> name.startsWith(letter);
        final long countFriendsStartN3 = 
            friends.stream()
                    .filter(startsWithLetter.apply("N")).count();
        final long countFriendsStartB3 = 
            friends.stream()
                    .filter(startsWithLetter.apply("B")).count();

    }

    public static Predicate<String> checkIfStartWith(final String letter) {
        return name -> name.startsWith(letter) ;
    }
}
