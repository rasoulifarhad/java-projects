package com.farhad.example.world_of_zuul.demo02;

import java.util.HashMap;
import java.util.Map;

public class Room {

    private String description;
    private Map<String, Room> exits;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
