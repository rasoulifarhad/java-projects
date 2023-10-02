package com.farhad.example.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickALongest {
    
    public static void main(String[] args) {
        final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        System.out.println("Total number of characters in all names: " +
                friends.stream()
                    .mapToInt(name -> name.length())
                    .sum());

        final Optional<String> aLongName =
            friends.stream()
                .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2 );
        aLongName.ifPresent( name -> System.out.println(String.format("A longest name: %s", name)));

        String steveOrLonger =
            friends.stream()
                .reduce("Steve", (name1, name2) -> name1.length() > name2.length() ? name1 : name2 );
        System.out.println(String.format("A longest name: %s", steveOrLonger));
    }
}
