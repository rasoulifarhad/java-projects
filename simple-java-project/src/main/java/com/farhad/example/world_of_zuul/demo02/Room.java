package com.farhad.example.world_of_zuul.demo02;

public class Room {

    private String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String description) {
        this.description = description;
    }

    public void setExits(Room northExit, Room southExit, Room eastExit, Room westExit) {
        if (northExit != null) {
            this.northExit = northExit;
        }
        if (southExit != null) {
            this.southExit = southExit;
        }
        if (eastExit != null) {
            this.eastExit = eastExit;
        }
        if (westExit != null) {
            this.westExit = westExit;
        }
    }

    public String getDescription() {
        return description;
    }

}
