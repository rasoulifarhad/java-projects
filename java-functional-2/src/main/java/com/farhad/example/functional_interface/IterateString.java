package com.farhad.example.functional_interface;

public class IterateString {
    public static void main(String[] args) {
        final String str = "w00t";

        str.chars().forEach(ch -> System.out.println(ch));

        str.chars().forEach(System.out::println);

        str.chars().forEach(IterateString::printChar);

        str.chars()
            .mapToObj(ch -> Character.valueOf((char)ch))
            .forEach(System.out::println);

        str.chars()
            .filter(ch -> Character.isDigit(ch))
            .forEach(System.out::println);
        str.chars()
            .filter(ch -> Character.isDigit(ch))
            .forEach(ch -> printChar(ch));

        str.chars()
            .filter(ch -> Character.isDigit(ch))
            .forEach(IterateString::printChar);
    }

    private static void printChar(int achar ) {
        System.out.println((char) achar);
    }
}
