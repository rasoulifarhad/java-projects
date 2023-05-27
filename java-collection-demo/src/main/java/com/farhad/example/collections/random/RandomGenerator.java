package com.farhad.example.collections.random;

public class RandomGenerator {
    
    public static double rndD() {
        return Math.random();
    }

    public static double rndD(int min, int max) {
       return ( Math.random() *  ( ( max - min ) + 1 )  + min );
    }
    public static int rndI(int min, int max) {
        return (int) Math.floor(rndD(min, max));
     }
 
}
