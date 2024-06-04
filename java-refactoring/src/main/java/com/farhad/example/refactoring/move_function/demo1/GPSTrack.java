package com.farhad.example.refactoring.move_function.demo1;

public class GPSTrack {


    public TrackSummary trackSummary(Point[] points) {
        int totalTime=  calculateTime();
        int totalDistance = calculateDistance(points);
        int pace = totalTime / 60 / totalDistance;
        return new TrackSummary(totalTime, totalDistance, pace);
    }

    private int calculateDistance(Point[] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            result += distance(points[i-1], points[i]);
        }
        return result;
    }

    private int distance(Point point, Point point2) {
        return 0;
    }

    private int calculateTime() {
        return 0;
    }
}
