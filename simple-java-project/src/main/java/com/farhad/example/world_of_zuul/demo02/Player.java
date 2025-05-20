package com.farhad.example.world_of_zuul.demo02;

public class Player {

    private String name;
    private Room currentRoom;
    private Items items;
    private double maxWeight = 1;

    public Player(String name) {
        this.name = name;
        items = new Items();
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

    public String getItemsString() {
        return "You are carrying: " + items.getLongItemString();
    }
   
    public String getLongDescription() {       
        String returnString = currentRoom.getLongDescription();
        returnString += "\n" + getItemsString();
        return returnString;
    } 
    
    public Item pickUpItem(String itemName) {
        if(canPickItem(itemName)) {
            Item item = currentRoom.removeItem(itemName);
            items.put(itemName, item);
            return item;
        }
        return null;
    }    

    public Item dropItem(String itemName) {
        Item item = items.remove(itemName);
        if(item != null){
            currentRoom.addItem(item);
        }
        return item;
    }    

   
    private boolean canPickItem(String itemName) {
        boolean canPick = true;
        Item item = currentRoom.getItem(itemName);
        if(item == null) {
            canPick = false;
        }
        double totalWeight = items.getTotalWeight() + item.getWeight();
        if(totalWeight > maxWeight) {
            canPick = false;
        }
        return canPick;
    }    
}
