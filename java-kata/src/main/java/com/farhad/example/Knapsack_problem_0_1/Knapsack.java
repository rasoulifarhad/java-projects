package com.farhad.example.Knapsack_problem_0_1;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Knapsack {
    
    private final double value;
    private final List<Item> items;
    private final int weight;
    private final int available;

    private Knapsack add(Item item) {
        return new Knapsack(
            this.value + item.getValue(), 
            this.items.cons(item), 
            this.weight + item.getWeight(), 
            this.available - item.getWeight());
    }

    // Allows knowing if the knapsack has enough available capacity to receive a given item.
    private boolean canAccept(Item item) {
        return item.getWeight() <= this.available;
    }

    // Compares two Knapsack instances and returns the one with the greatest value.
    private Knapsack maxValue(Knapsack that) {
        return this.value >= that.value ? this : that;
    }

    // @Override
    // public String toString() {
    //     return String.format("Total value: %s\nTotal weight: %s\nItems:\n%s",
    //                 value, 
    //                 weight, 
    //                 items.foldRight(
    //                     "",
    //                     (item, string) -> String.format("\t%s\n%s", item, string)));    
    //     }

    private static Knapsack empty(int capacity) {
        return new Knapsack(
            0.0, 
            List.<Item>list(), 
            0, 
            capacity);
    }    

    // Takes a list of items and a Knapsack and returns the Knapsack (in fact a new one) 
    // with as much value as possible packed into it. 
    // private static Knapsack pack(List<Item> items, Knapsack knapsack) {

    // }    

    // public static Knapsack pack(List<Item> items, int knapsackCapacity) {
    //     return pack(items, empty(knapsackCapacity));
    // }    

    public static void main(String[] args) {
        
        int capacity = 400;

        final List<Item> items = List.<Item>list()
            .cons(new Item("map", 9, 150.0))
            .cons(new Item("compass", 13, 35.0))
            .cons(new Item("water", 153, 200.0))
            .cons(new Item("sandwich", 50, 160.0))
            .cons(new Item("glucose", 15, 60.0))
            .cons(new Item("tin", 68, 45.0))
            .cons(new Item("banana", 27, 60.0))
            .cons(new Item("apple", 39, 40.0))
            .cons(new Item("cheese", 23, 30.0))
            .cons(new Item("beer", 52, 10.0))
            .cons(new Item("cream", 11, 70.0))
            .cons(new Item("camera", 32, 30.0))
            .cons(new Item("tshirt", 24, 15.0))
            .cons(new Item("trousers", 48, 10.0))
            .cons(new Item("umbrella", 73, 40.0))
            .cons(new Item("trousers", 42, 70.0))
            .cons(new Item("overclothes", 43, 75.0))
            .cons(new Item("notecase", 22, 80.0))
            .cons(new Item("sunglasses", 7, 20.0))
            .cons(new Item("towel", 18, 12.0))
            .cons(new Item("socks", 4, 50.0))
            .cons(new Item("book", 30, 10.0));
    
        // System.out.println(Knapsack.pack(items, capacity));        
    }
}
