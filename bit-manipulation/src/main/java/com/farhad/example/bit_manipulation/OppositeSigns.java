package com.farhad.example.bit_manipulation;

public class OppositeSigns {

    public boolean areOfOppositeSigns(int a, int b) {
        return (a >= 0) != (b>= 0);
    }


    // most significant bit of negative number will be 1, 
    // most significant bit of positive number will be zero 
    // XOR between 1 and 0 will  be 1 hence the result will be negative
    public boolean areOfOppositeSignsBitwise(int a, int b) {
        return (a ^ b) < 0;
    }

}
