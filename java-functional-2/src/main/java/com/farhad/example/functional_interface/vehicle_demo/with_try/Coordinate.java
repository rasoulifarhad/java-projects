package com.farhad.example.functional_interface.vehicle_demo.with_try;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Coordinate {

    public static final Coordinate UNKNOWN = new Coordinate(0 ,0 );
    
    private final int latitude;
    private final int longitude;

    public Coordinate plus(Coordinate coordinate) {
        return new Coordinate(latitude + coordinate.getLatitude(), longitude + coordinate.getLongitude());
    }

    @Override
    public String toString() {
        return String.format("Coordinate [latitude = %s, longitude = %s]", latitude, longitude);
    }     
}
