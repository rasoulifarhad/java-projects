package com.farhad.example.random;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomGenerator {
    
    public static double rnd() {
        return Math.random();
    }

    public static double rnd(double min, double max) {
        return ( Math.random() *  ( ( max - min ) + 1 )  + min );
     }

    public static int rndI(int min, int max) {
        return (int) Math.floor(rnd(min, max));
        // return (int) rnd(min, max);
     }

     public static int generateRandom(int max) {
        Random random = new Random() ;
        return random.nextInt(max);
     }

     public static int generateRandom(int min, int max) {
        Random random = new Random() ;
        return random.nextInt( ( max - min ) + 1 ) + min ;
     }

     public static int generateRandomWithInts(){
        Random random = new Random();
        return random.ints().findAny().getAsInt();

     }

     public static int generateRandomWithInts(int min, int max){
        Random random = new Random();
        return random.ints(min, max + 1 )
                    .findFirst()
                    .getAsInt();

     }

     public static List<Integer> generateListOfRandomInts(int size) {
        Random random = new Random();
        return random.ints(size)
                        .boxed()
                        .collect(Collectors.toList());
     }

     public static List<Integer> generateListOfRandomIntsWithLambda(int size) {
        Random random = new Random();
        return random.ints()
                        .boxed()
                        .limit(size)
                        .collect(Collectors.toList());
     }

     public static List<Integer> generateListOfRandomInts(int size, int min, int max) {
        Random random = new Random();
        return random.ints(size, min, max + 1)
                        .boxed()
                        .collect(Collectors.toList());
     }

     public static List<Integer> generateSortedListOfRandomInts(int size, int min, int max) {
        Random random = new Random();
        return random.ints(size, min, max + 1)
                        .sorted()
                        .boxed()
                        .collect(Collectors.toList());
     }

}
