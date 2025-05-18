package com.farhad.example.birdfeeder;

import java.util.ArrayList;
import java.util.List;

public class BirdFeeder {

    private static final int ON_THRESHOLD = 40;
    private static final int OFF_THRESHOLD = 25;

    private Integer lightLevel;
    private Sensor sensor;
    private List<FeedingDoor> feedingDoors;
    private List<Song> songs;

    public BirdFeeder() {
        feedingDoors =  new ArrayList<>();
        sensor = new Sensor();
        feedingDoors.add(new FeedingDoor());
        lightLevel = 0;
        songs = new ArrayList<>();
    }

    public BirdFeeder(Sensor sensor, List<FeedingDoor> feedingDoors) {
        this.sensor = sensor;
        this.feedingDoors = new ArrayList<>(feedingDoors);
        lightLevel = 0;
    }

    public void operate() {
        lightLevel = sensor.getLevel();
        if (isTimeToOpen()) {
            openDoors();
        }
        if (isTimeToClose()) {
            closeDoors();
        }
    }

    private void closeDoors() {
        for (FeedingDoor feedingDoor : feedingDoors) {
            feedingDoor.close();
            System.out.println("The door has closed.");
        }
    }

    private void openDoors() {
        for (FeedingDoor feedingDoor : feedingDoors) {
            feedingDoor.open();
            System.out.println("The door has opened.");
        }
    }

    private boolean isTimeToOpen() {
        return lightLevel > ON_THRESHOLD;
    }

    private boolean isTimeToClose() {
        return lightLevel < OFF_THRESHOLD;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs);
    }

    public List<FeedingDoor> getFeedingDoor() {
        return new ArrayList<>(feedingDoors);
    }
}
