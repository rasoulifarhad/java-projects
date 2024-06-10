package com.farhad.example.remote_controlled_ship;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Location {

    private static final int FORWARD = 1;
    private static final int BACKWARD = -1;

    @Getter
    private Point point;

    @Getter
    @Setter
    private Direction direction;

    public Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public boolean forward() {
        return move(FORWARD, new Point(100, 100), new ArrayList<>());
    }

    public boolean forward(Point max) {
        return move(FORWARD, max, new ArrayList<>());
    }

    public boolean forward(Point max, List<Point> obstacles) {
        return move(FORWARD, max, obstacles);
    }

    public boolean backward() {
        return move(BACKWARD, new Point(100, 100), new ArrayList<>());
    }

    public boolean backward(Point max) {
        return move(BACKWARD, max, new ArrayList<>());
    }

    public boolean backward(Point max, List<Point> obstacles) {
        return move(BACKWARD, max, obstacles);
    }

    private boolean move(int fw, Point max, List<Point> obstacles) {
        int x = point.getX();
        int y = point.getY();
        switch (getDirection()) {
            case NORTH:
                y = wrap(getY() - fw, max.getY());
                break;
            case SOUTH:
                y = wrap(getY() + fw, max.getY());
            break;
            case EAST:
                x = wrap(getX() + fw, max.getX());
            break;
            case WEST:
                x = wrap(getX() - fw, max.getX());
            break;
        
            default:
                break;
        }
        if(isObstacle(new Point(x, y), obstacles)) {
            return false;
        } else {
            point = new Point(x, y);
            return true;
        }
    }

    private boolean isObstacle(Point point, List<Point> obstacles) {
        for (Point obstacle : obstacles) {
            if (obstacle.getX() == point.getX() && obstacle.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }    

    private int wrap(int point, int maxPoint){
        if(maxPoint > 0) {
            if(point > maxPoint) {
                return 1;
            } else if(point == 0){
                return maxPoint;
            }
        }
        return point;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        if (getX() != location.getX()) return false;
        if (getY() != location.getY()) return false;
        if (direction != location.direction) return false;
        return true;
    }  
    
    public void turnLeft() {
        this.direction = direction.turnLeft();
    }

    public void turnRight() {
        this.direction = direction.turnRight();
    }

    public Location copy() {
        return new Location(new Point(point.getX(), point.getY()), direction);
    }    
}
