package com.farhad.example.world_of_zuul.demo02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Items {
    private Map<String, Item> items;

    public Items() {
        this.items = new HashMap<>();
    }

    public Item remove(String name) {
        return items.remove(name);
    }

    public void put(String name, Item item) {
        items.put(name, item);
    }

    public Item get(String name) {
        return items.get(name);
    }

    public String getItemString() {
        String listOfItems= " Items:";
        Set<String> keys = items.keySet();
        for (String item : keys) {
            listOfItems += " " + item;
        }
        return listOfItems;
    }

    public String getLongItemString() {
        String listOfItems= " Items:";
        Collection<Item> values = items.values();
        for (Item item : values) {
            listOfItems += " " + item.getDescription();
        }
        return listOfItems;
    }


    public double getTotalWeight() {
        double total = 0;
        for (Item item : items.values()) {
            total += item.getWeight();
        }
        return total;
    }

}
