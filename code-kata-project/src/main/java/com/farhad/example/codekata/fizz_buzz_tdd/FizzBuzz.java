package com.farhad.example.codekata.fizz_buzz_tdd;

public class FizzBuzz {

    public String trasnsform(int source) {
        if(source == 1) {
            return String.valueOf(source);        
        }
        if(source == 2) {
            return String.valueOf(source);        
        }
        if(source == 3) {
            return String.valueOf(source);        
        }
        throw new IllegalArgumentException("WE BROKE SOMETHING");
    }

}
