package com.farhad.example.remote_controlled_ship;

import lombok.Getter;
import lombok.Setter;

public class Location {

    @Getter
    private Point point;

    @Getter
    @Setter
    private Direction direction;

    public Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    
}
