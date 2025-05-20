package com.farhad.example.world_of_zuul.demo02;

public class Room {

    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

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

    public Room getExit(String direction) {
        if (direction.equals("north")) {
            return northExit;
        }
        if (direction.equals("east")) {
            return eastExit;
        }
        if (direction.equals("south")) {
            return southExit;
        }
        if (direction.equals("west")) {
            return westExit;
        }
        return null;
    }
}
