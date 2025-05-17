package com.farhad.example.birdfeeder;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {

    private List<FeedingDoor> feedingDoors;

    public RemoteControl() {
        feedingDoors = new ArrayList<>();
        feedingDoors.add(new FeedingDoor());
    }

    public void pressButton() {

        for (FeedingDoor feedingDoor : feedingDoors) {
            if(feedingDoor.isDoorOpen()) {
                feedingDoor.close();
            } else {
                feedingDoor.open();
            }
        }
    }
}
