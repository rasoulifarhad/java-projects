package com.farhad.example.codekata.fizz_buzz_tdd;

public class FizzBuzz {

    public String trasnsform(int source) {
        if(0 == source % 3) {
            return "Fizz";
        }
        return String.valueOf(source);        
    }

}
