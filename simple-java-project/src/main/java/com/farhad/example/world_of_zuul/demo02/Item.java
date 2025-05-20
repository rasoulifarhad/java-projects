package com.farhad.example.world_of_zuul.demo02;

public class Item {

    private String description;
    private double weight;
    private boolean canTake;

    public Item(String description, double weight, boolean canTake) {
        this.description = description;
        this.weight = weight;
        this.canTake = canTake;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isCanTake() {
        return canTake;
    }

    
}
