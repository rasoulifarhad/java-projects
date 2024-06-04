package com.farhad.example.refactoring.move_function.demo2;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class GPSTrack {


    public TrackSummary trackSummary(Point[] points) {
        
        BiFunction<Point, Point, Integer> distance = (p1, p2) -> {
            return 0;
        };
        Supplier<Integer> calculateDistance = () -> {
            int result = 0;
            for (int i = 0; i < points.length; i++) {
                result += distance.apply(points[i-1], points[i]);
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


    // public int top_calculateDistance() {
    //     int result = 0;
    //     for (int i = 0; i < points.length; i++) {
    //         result += distance(points[i-1], points[i]);
    //     }
    //     return result;
    // }

}
