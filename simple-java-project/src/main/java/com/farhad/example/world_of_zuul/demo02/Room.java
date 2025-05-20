package com.farhad.example.world_of_zuul.demo02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Room {

    private String description;
    private Map<String, Room> exits;
    private Map<String, Item> items;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description +  ".\n" + getExitString() + "\n" + getItemString();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getExitString() {
        String  returnString = "Exits: ";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exits.get(exit);
        }
        return returnString;
    }

    public String getItemString() {
        String listOfItems= " Items:";
        Set<String> keys = items.keySet();
        for (String item : keys) {
            listOfItems += " " + item;
        }
        return listOfItems;
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }
}
