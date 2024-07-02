package com.farhad.example.design_principles03.meaningful_context;

public class Main {


    private void printGuessStatics(char candidate, int count) {
        String number;
        String verb;
        String pluralModifier;
        if(count == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if(count == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = "";
            verb = "are";
            pluralModifier = "s";
        }
        String guessMessage = String.format(
            "There %s %s %s%s", verb, number, candidate, pluralModifier);
        print(guessMessage);
    }

    private void print(String guessMessage) {
        System.out.println(guessMessage);
    }
}
