package com.farhad.example.refactoring.move_function.demo2;

import lombok.Value;

@Value
public class TrackSummary {

    private int totalTime;
    private double totalDistance;
    private double pace;

    public TrackSummary(int totalTime, double totalDistance, double pace) {
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.pace = pace;
    }

}
