package com.farhad.example.codekata.number_guessing_game;

import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        
        Scanner scaner = new Scanner(System.in);
        int numberToGuess = 1 + (int)(100 * Math.random());
        int attempts = 5;
        
        System.out.println("A number is chosen between 1 to 100.");
        System.out.println("Guess the number whithin 5 trials.");

        boolean win = false;
        int guess;
        int numberOfTries;
        for (numberOfTries = 0; numberOfTries < attempts; numberOfTries++) {
            System.out.println("Guess the number:");
            guess = scaner.nextInt();
            if(numberToGuess == guess){
                win = true;
                break;
            } else if(guess < numberToGuess) {
                System.out.println("Your guess is to low. Try again:");
            } else {
                System.out.println("Your guess is to high. Try again:");
            }
        }
        if (win) {
            System.out.println("Congratulations! You guessed the number.");
            System.out.println("The number was " + numberToGuess);
            System.out.println("It took you " + numberOfTries + " tries" );
        } else {
            System.out.println("Oppssss!.");
            System.out.println("The number was " + numberToGuess);
        }

        scaner.close();
    }
}
