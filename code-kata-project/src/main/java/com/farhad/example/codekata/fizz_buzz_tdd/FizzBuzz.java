package com.farhad.example.codekata.fizz_buzz_tdd;

public class FizzBuzz {

    public String trasnsform(int source) {
        if(source == 4 * 5) {
            return "Buzz";
        }
        if(source == 2 * 5) {
            return "Buzz";
        }
        if(source == 1 * 5) {
            return "Buzz";
        }

        if(0 == source % 3) {
            return "Fizz";
        }
        return String.valueOf(source);        
    }

}
