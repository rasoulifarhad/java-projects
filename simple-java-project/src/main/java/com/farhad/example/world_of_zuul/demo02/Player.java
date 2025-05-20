package com.farhad.example.world_of_zuul.demo02;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private Map<String, Item> bag;
    private double weightLimit;
    private Room currentRoom;


    public Player(String name, double weightLimit) {
        this.name = name;
        this.weightLimit = weightLimit;
        bag = new HashMap<>();
    }

    public String getName() {
        return name;
    }

   public double getWeightLimit() {
        return weightLimit;
    }

    public void pickUpItem(String itemName) {
    }

    public Item dropItem(String itemName) {
        return null;
    }

    public void setRoom(Room room){
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    
}
