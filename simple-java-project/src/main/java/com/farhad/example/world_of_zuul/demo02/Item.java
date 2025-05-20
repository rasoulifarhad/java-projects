package com.farhad.example.world_of_zuul.demo02;

public class Item {

    private String name;
    private String description;
    private double weight;
    private boolean canBePickedUp;

    public Item(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    
    
}
