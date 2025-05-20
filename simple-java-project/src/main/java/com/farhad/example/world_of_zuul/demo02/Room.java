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
        return "You are " + description +  ".\n" + getExitString();
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

    public String listItems() {
        String listOfItems= " has:";
        if(items.isEmpty() ) {
            listOfItems += " nothing";
        } else {
            Set<String> keys = items.keySet();
            for (String item : keys) {
                listOfItems += " " + item;
            }
        }
        return listOfItems;
    }

    public String look(){
        return getExitString() + "\n" + listItems();
    }        

    public boolean contains(String itemName) {
        return items.containsKey(itemName);
    }

    public Item getItem(String itemName) {
        return items.get(itemName); 
    }

    public Item take(String itemName) {
        return items.remove(itemName);
    }

    public void store(Item item) {
        items.put(item.getName(), item);
    }
}
