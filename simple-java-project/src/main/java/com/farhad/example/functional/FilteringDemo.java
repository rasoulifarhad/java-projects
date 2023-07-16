package com.farhad.example.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FilteringDemo {
    
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if("green".equals(apple.getColor())) {
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getWeight() > 150) {
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    @AllArgsConstructor
    @Data
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }

    public static void main(String[] args) {
        
        List<Apple> inventory = new ArrayList<Apple>() {
            {
                add(new Apple(80, "green"));
                add(new Apple(155, "green"));
                add(new Apple(120, "red"));
            }
        };

        List<Apple> greenApples = filterApple(inventory, FilteringDemo::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApple(inventory, FilteringDemo::isHeavyApple);
        System.out.println(heavyApples);

        List<Apple> redApples = filterApple(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(redApples);

        List<Apple> thinApples = filterApple(inventory, (Apple apple) -> apple.getWeight() < 150);
        System.out.println(thinApples);
    }
}
