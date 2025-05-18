package com.farhad.example.birdfeeder;

import java.util.List;

public class SongIdentifier {

    private BirdFeeder birdFeeder;
    private List<FeedingDoor> feedingDoors;

    public SongIdentifier(BirdFeeder birdFeeder) {
        this.birdFeeder = birdFeeder;
        this.feedingDoors = birdFeeder.getFeedingDoor();
    }

    public void identify(Song song) {
        List<Song> songs = birdFeeder.getSongs();
        for (Song nextSong : songs) {
            if(nextSong.equals(song)) {
                openDoors();
                return;
            }
        }
        closeDoors();
    }

    private void closeDoors() {
        for (FeedingDoor feedingDoor : feedingDoors) {
            feedingDoor.close();
        }
    }

    private void openDoors() {
        for (FeedingDoor feedingDoor : feedingDoors) {
            feedingDoor.close();
        }
    }

    
}
