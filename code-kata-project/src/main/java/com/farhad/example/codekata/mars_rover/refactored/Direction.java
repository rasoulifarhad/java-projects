package com.farhad.example.codekata.mars_rover.refactored;

public enum Direction {
    North {
        @Override
        public Direction turnRight() {
            return East;
        }

        @Override
        public Direction turnLeft() {
            return West;
        }

        @Override
        public Coordinates moveForward(Coordinates coordinates, int delta) {
            return coordinates.incrementY(delta);
        }

        @Override
        public Coordinates moveBackwards(Coordinates coordinates, int delta) {
            return coordinates.incrementY(-delta);
        }
    }, 
    South {
        @Override
        public Direction turnRight() {
            return West;
        }

        @Override
        public Direction turnLeft() {
            return East;
        }

        @Override
        public Coordinates moveForward(Coordinates coordinates, int delta) {
            return coordinates.incrementY(-delta);
        }

        @Override
        public Coordinates moveBackwards(Coordinates coordinates, int delta) {
            return coordinates.incrementY(delta);
        }
    }, 
    East {
        @Override
        public Direction turnRight() {
            return South;
        }

        @Override
        public Direction turnLeft() {
            return North;
        }

        @Override
        public Coordinates moveForward(Coordinates coordinates, int delta) {
            return coordinates.incrementX(delta);
        }

        @Override
        public Coordinates moveBackwards(Coordinates coordinates, int delta) {
            return coordinates.incrementX(-delta);
        }
    }, 
    West {
        @Override
        public Direction turnRight() {
            return North;
        }

        @Override
        public Direction turnLeft() {
            return South;
        }

        @Override
        public Coordinates moveForward(Coordinates coordinates, int delta) {
            return coordinates.incrementX(-delta);
        }

        @Override
        public Coordinates moveBackwards(Coordinates coordinates, int delta) {
            return coordinates.incrementX(delta);
        }
    };

    public static Direction parse(String directionAsString) {

        if (directionAsString.equals("N")) {
            return North;
        } else if (directionAsString.equals("E")) {
            return East;
        } else if (directionAsString.equals("S")) {
            return South;
        } else {
            return West;
        }        
    }
    
    public abstract Direction turnRight();
    public abstract Direction turnLeft();

    public abstract Coordinates moveForward(Coordinates coordinates, int delta);
    public abstract Coordinates moveBackwards(Coordinates coordinates, int delta);

}
