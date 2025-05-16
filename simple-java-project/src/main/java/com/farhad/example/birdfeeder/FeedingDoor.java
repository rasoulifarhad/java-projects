package com.farhad.example.birdfeeder;

public class FeedingDoor {

    private boolean doorOpen;

    public FeedingDoor() {
        doorOpen = false;
    }

    public void open() {
        if (!doorOpen) {
            doorOpen = true;
        }
    }

    public void close() {
        if (doorOpen) {
            doorOpen = false;
        }
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

}
