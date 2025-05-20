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

    public void setExits(Room northExit, Room southExit, Room eastExit, Room westExit) {
        if (northExit != null) {
            exits.put("north", northExit);
        }
        if (southExit != null) {
            exits.put("south", southExit);
        }
        if (eastExit != null) {
            exits.put("east", eastExit);
        }
        if (westExit != null) {
            exits.put("west", westExit);
        }
    }

    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
