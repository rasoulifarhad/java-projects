package com.farhad.example.java_tips;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AsMatchPredicate {

    public static void main(String[] args) {
        new AsMatchPredicate().demo();
    }

    private void demo() {

        System.out.println("asPredicate:");
        Predicate<String> stringPredicate = Pattern.compile("cat").asPredicate();
        Stream.of("cat", "dog","fish", "Felis catus").filter(stringPredicate).forEach(System.out::println);

        System.out.println("asMatchPredicate:");
        Predicate<String> stringMatchPredicate = Pattern.compile("cat").asMatchPredicate();
        Stream.of("cat", "dog","fish", "Felis catus").filter(stringMatchPredicate).forEach(System.out::println);
    }
}
