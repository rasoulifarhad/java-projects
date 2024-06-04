package com.farhad.example.refactoring.move_function.demo2;

import java.util.function.Supplier;

public class GPSTrack {


    public TrackSummary trackSummary(Point[] points) {


        Supplier<Double> calculateDistance = () -> {
            double result = 0;
            for (int i = 0; i < points.length; i++) {
                result += distance(points[i-1], points[i]);
            }
           return result;
        };

        Supplier<Integer> calculateTime = () -> {
            return 0;
        };
        int totalTime =  calculateTime.get();
        double totalDistance = calculateDistance.get();
        double pace = totalTime / 60 / totalDistance;
        return new TrackSummary(totalTime, totalDistance, pace);
    }

    public double top_calculateDistance(Point[] points) {
        double result = 0;
        for (int i = 0; i < points.length; i++) {
            result += distance(points[i-1], points[i]);
        }
       return result;
    }

    public double distance(Point p1, Point p2) {
        final int EARTH_RADIUS = 3959; //in miles
        double dLat =  radians(p2.getLat()) - radians(p1.getLat());
        double dLon =  radians(p2.getLon()) - radians(p1.getLon());
        double a = Math.pow(Math.sin(dLat / 2), 2)
                 + Math.cos(radians(p2.getLat()))
                 + Math.cos(radians(p1.getLat()))
                 + Math.pow(Math.sin(dLon /2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }



    public double radians(double degrees) {
        return degrees * Math.PI /180;
    }

}
