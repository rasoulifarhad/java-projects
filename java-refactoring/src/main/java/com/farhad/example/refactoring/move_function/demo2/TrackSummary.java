package com.farhad.example.refactoring.move_function.demo2;

import lombok.Value;

@Value
public class TrackSummary {

    private int totalTime;
    private int totalDistance;
    private int pace;

    public TrackSummary(int totalTime, int totalDistance, int pace) {
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.pace = pace;
    }

}
