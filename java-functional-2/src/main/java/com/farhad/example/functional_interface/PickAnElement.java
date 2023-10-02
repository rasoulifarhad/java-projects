package com.farhad.example.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElement {
    
    public static void main(String[] args) {
        final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        pickNameFuntional(friends, "N");
        pickNameFuntional(friends, "Z");
    }

    public static void pickName(final List<String> names, final String startingLetter) {
        String foundName = null;
        for (String name : names) {
            if(name.startsWith(startingLetter)) {
                foundName = name;
                break;

            }
        }
        System.out.print(String.format("A name starting with %s: ", startingLetter));
        if(foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void pickNameFuntional(final List<String> names, final String startingLetter) {
        final Optional<String> foundName = 
            names.stream()
                    .filter(name -> name.startsWith(startingLetter))
                    .findFirst();
        foundName.ifPresent(name -> System.out.println("Hello " + name));
        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("No name found.")));
    }
}
