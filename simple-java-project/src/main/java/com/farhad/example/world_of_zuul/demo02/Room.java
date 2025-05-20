package com.farhad.example.world_of_zuul.demo02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Room {

    private String description;
    private Map<String, Room> exits;
    private Items items;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new Items();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description +  ".\n" + getExitString() + "\n" + items.getLongItemString();
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


    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public Item getItem(String name) {
        return items.get(name);
    }

    public Item removeItem(String name) {
        return items.remove(name);
    }

}
