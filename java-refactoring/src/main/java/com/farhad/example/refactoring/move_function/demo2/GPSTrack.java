package com.farhad.example.refactoring.move_function.demo2;

import java.util.function.Supplier;

public class GPSTrack {


    public TrackSummary trackSummary(Point[] points) {
        Supplier<Integer> calculateDistance = () -> {
            int result = 0;
            for (int i = 0; i < points.length; i++) {
                result += distance(points[i-1], points[i]);
            }
           return result;
        };

        Supplier<Integer> calculateTime = () -> {
            return 0;
        };
        int totalTime =  calculateTime.get();
        int totalDistance = calculateDistance.get();
        int pace = totalTime / 60 / totalDistance;
        return new TrackSummary(totalTime, totalDistance, pace);
    }

    private int distance(Point point, Point point2) {
        return 0;
    }

    public int top_calculateDistance(Point[] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            result += distance(points[i-1], points[i]);
        }
        return result;
    }

}
