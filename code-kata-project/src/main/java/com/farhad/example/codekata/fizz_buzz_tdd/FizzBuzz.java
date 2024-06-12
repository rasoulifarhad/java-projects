package com.farhad.example.codekata.fizz_buzz_tdd;

public class FizzBuzz {

    public String trasnsform(int source) {
        if(source == 1) {
            return "1";        
        }
        if(source == 2) {
            return "2";        
        }
        if(source == 3) {
            return "3";        
        }
        throw new IllegalArgumentException("WE BROKE SOMETHING");
    }

}
