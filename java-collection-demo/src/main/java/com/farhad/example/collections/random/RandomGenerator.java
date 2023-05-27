package com.farhad.example.collections.random;

public class RandomGenerator {
    
    public static double rnd() {
        return Math.random();
    }

    public static double rnd(double min, double max) {
        return ( Math.random() *  ( ( max - min ) + 1 )  + min );
     }

    public static int rndI(int min, int max) {
        return (int) Math.floor(rnd(min, max));
     }
 
}
