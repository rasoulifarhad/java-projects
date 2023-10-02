package com.farhad.example.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PickElementsMultipleCollection {
    public static void main(String[] args) {
        
        final List<String> friends =
        Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors =
        Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades =
        Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");  
        
        final long countFriendsStartN = 
            friends.stream()
                    .filter(name -> name.startsWith("N")).count();
        final long countEditorsStartN = 
            editors.stream()
                    .filter(name -> name.startsWith("N")).count();

        final long countComradesStartN = 
            comrades.stream()
                    .filter(name -> name.startsWith("N")).count();

        final Predicate<String> startWithN = name -> name.startsWith("N");
        final long countFriendsStartN2 = 
            friends.stream()
                    .filter(startWithN).count();
        final long countEditorsStartN2 = 
            editors.stream()
                    .filter(startWithN).count();

        final long countComradesStartN2 = 
            comrades.stream()
                    .filter(startWithN).count();
    }
}
