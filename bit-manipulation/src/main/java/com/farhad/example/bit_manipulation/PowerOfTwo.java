package com.farhad.example.bit_manipulation;

public class PowerOfTwo {

    public boolean isPowerOf2(int num){
        while (num % 2 == 0) {
            num /= 2;
        }

        return num == 1;
    }

    public boolean isPowerOf2BW(int num){
        return (num & (num - 1)) == 0;
    }

}
