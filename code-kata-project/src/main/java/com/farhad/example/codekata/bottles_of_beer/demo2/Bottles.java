package com.farhad.example.codekata.bottles_of_beer.demo2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bottles {

    public static void main(String[] args) {
        Bottles bottles = new Bottles();
        System.out.println();
        System.out.println(bottles.song());
    }

    public String song() {
        return verses(99, 0);
    }

    private String verses(int bottlesAtStart, int bottlesAtEnd) {
        return reverseOrderStream(IntStream.rangeClosed(bottlesAtEnd, bottlesAtStart))
           .mapToObj(b -> verse(b))
           .collect(Collectors.joining("\n"));
   }

    public IntStream reverseOrderStream(IntStream intStream) {
        int[] tempArray = intStream.toArray();
        return IntStream.range(1, tempArray.length + 1)
                .boxed()
                .mapToInt(i -> tempArray[tempArray.length - i]);
    }

    private String verse(int bottles) {
        return challenge(bottles) + response(bottles);
    }

    private String challenge(int bottles) {
        return challengeBottlesOfBeer(bottles)
                + " "
                + onWall()
                + ", "
                + challengeBottlesOfBeer(bottles)
                + ".\n";
    }

    private String response(int bottles) {
        return goToTheStoreOrTakeOneDown(bottles)
                + ", "
                + responseBottlesOfBeer(bottles)
                + " "
                + onWall()
                + ".\n";
    }

    private String responseBottlesOfBeer(int bottles) {
        bottles = bottles - 1 < 0 ? 99 : bottles - 1;
        return bottleCount(bottles)
                + " "
                + pluralizedChallengBottleForm(bottles)
                + " of "
                + beer();
    }

    private String challengeBottlesOfBeer(int bottles) {

        return bottleCount(bottles)
                + " "
                + pluralizedChallengBottleForm(bottles)
                + " of "
                + beer();
    }

    private String onWall() {
        return "on the wall";
    }

    private String goToTheStoreOrTakeOneDown(int bottles) {
        return isAllOut(bottles) 
                    ? buyNewBeer() 
                    : drinkBeer(bottles);
    }

    private String bottleCount(int bottles) {
        return isAllOut(bottles) ? "No more" : String.valueOf(bottles);
    }

    private String pluralizedChallengBottleForm(int bottles) {
        return isLastBeer(bottles) 
                    ? "bottle" 
                    : "bottles";
    }

    private String beer() {
        return "beer";
    }

    private String buyNewBeer() {
        return "Go to the store and buy some more";
    }

    private String drinkBeer(int bottles) {
        return "Take " 
                + itOrOne(bottles) 
                + " down and pass it around";
    }

    private boolean isLastBeer(int bottles) {
        return bottles == 1;
    }

    private boolean isAllOut(int bottles) {
        return bottles == 0;
    }

    private String itOrOne(int bottles) {
        return isLastBeer(bottles) ? "it" : "one";
    }

    // private String pluralizedResponseBottleForm(int bottles) {
    // return bottles == 1 ? "bottle" : "bottles";
    // }

}
