package com.farhad.example.codekata.fizz_buzz_tdd;

public class FizzBuzz {

    public String trasnsform(int source) {
        if(source == 1 || source == 2 || source == 3) {
            return String.valueOf(source);        
        }
        throw new IllegalArgumentException("WE BROKE SOMETHING");
    }

}
