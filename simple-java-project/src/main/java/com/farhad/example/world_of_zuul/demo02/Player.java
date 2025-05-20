package com.farhad.example.world_of_zuul.demo02;

public class Player {

    private String name;
    private Room currentRoom;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void enterRoom(Room room){
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

   
}
