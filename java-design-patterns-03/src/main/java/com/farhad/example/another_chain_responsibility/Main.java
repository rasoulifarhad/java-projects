package com.farhad.example.another_chain_responsibility;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Bait> allBaits = new HashMap<Integer, Bait>() {
            {
                put(Integer.valueOf(1), Bait.POPCORN);
                put(Integer.valueOf(2), Bait.SAUSAGE);
                put(Integer.valueOf(3), Bait.CHOCOLATE_CAKE);
            }
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("what kind of bait do you want touse in your trap?");
        for (Map.Entry<Integer, Bait> bait : allBaits.entrySet()) {
            System.out.printf("    %s - %s%n", bait.getKey(), bait.getValue());
        }
        String baitString = sc.nextLine();
        int baitChoice = Integer.parseInt(baitString);
        if(baitChoice < 1 || baitChoice > 3) {
            System.out.println("You dont have that bait. try again.");
            return;
        }
        Bait bait = allBaits.get(baitChoice);
        Pet chainOfresp = new Hamster(new Cat(new Dog(null)));

        System.out.println("The bait was taken! Trap contents: " + chainOfresp.handleTrap(bait));
        sc.close();
    }
}
