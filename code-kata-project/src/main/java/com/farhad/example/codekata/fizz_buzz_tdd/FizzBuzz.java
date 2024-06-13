package com.farhad.example.codekata.fizz_buzz_tdd;

public class FizzBuzz {

    public String trasnsform(int source) {
        if(0 == source % 15) {
            return "FizzBuzz";
        }
        if(source == 3 * (3 * 5)) {
            return "FizzBuzz";
        }
        if(source == 2 * (3 * 5)) {
            return "FizzBuzz";
        }
        if(source == 1 * (3 * 5)) {
            return "FizzBuzz";
        }
        if(0 == source % 5) {
            return "Buzz";
        }
        if(0 == source % 3) {
            return "Fizz";
        }
        return String.valueOf(source);        
    }

}
