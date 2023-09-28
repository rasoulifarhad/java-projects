package com.farhad.example.functional_interface.vehicle_demo.with_lazy_try;

public interface Vehicle {
 
    Vehicle wakeUp();

    Vehicle moveForward(Distance distance);

    Vehicle moveLeft(Distance distance);

    Vehicle moveRight(Distance distance);

    Vehicle stop();

    Coordinate currentPosition();

    class Default implements Vehicle {
        final Coordinate coordinate;

        Default(Coordinate coordinate) {
            this.coordinate = coordinate;
        }

        Default() {
            this(Coordinate.UNKNOWN);
        }

        @Override
        public Vehicle wakeUp() {
            System.out.println("vehicle is waking up.");
            return this;
        }

        @Override
        public Vehicle moveForward(Distance distance) {
            System.out.println("moving forward " + distance);
            return new Default(this.currentPosition().plus(new Coordinate(distance.getValue(), distance.getValue())));
        }

        @Override
        public Vehicle moveLeft(Distance distance) {
            System.out.println("moving left " + distance);
            return new Default(this.currentPosition().plus(new Coordinate(distance.getValue(), 0)));
        }

        @Override
        public Vehicle moveRight(Distance distance) {
            System.out.println("moving right " + distance);
            return new Default(this.currentPosition().plus(new Coordinate(0, distance.getValue())));
        }

        @Override
        public Vehicle stop() {
            System.out.println("stopping the vehicle");
            return this;
        }

        @Override
        public Coordinate currentPosition() {
            return coordinate;
        }

        @Override
        public String toString() {
            return String.format("[Vehicle: coordinates: [%s] ]", this.currentPosition());
        }
    }

    class UnableToMoveForward implements Vehicle {

        final Coordinate coordinate;

        UnableToMoveForward(Coordinate coordinate) {
            this.coordinate = coordinate;
        }

        UnableToMoveForward() {
            this(Coordinate.UNKNOWN);
        }

        @Override
        public Vehicle wakeUp() {
            System.out.println("vehicle is waking up.");
            return new UnableToMoveForward(this.currentPosition());
        }

        @Override
        public Vehicle moveForward(Distance distance) {
            System.out.println("moving forward " + distance);
            throw new RuntimeException("Unable to move the vehicle forward");
        }

        @Override
        public Vehicle moveLeft(Distance distance) {
            System.out.println("moving left " + distance);
            return new UnableToMoveForward(this.currentPosition().plus(new Coordinate(distance.getValue(), 0)));
        }

        @Override
        public Vehicle moveRight(Distance distance) {
            System.out.println("moving right " + distance);
            return new UnableToMoveForward(this.currentPosition().plus(new Coordinate(0, distance.getValue())));
        }

        @Override
        public Vehicle stop() {
            System.out.println("stopping the vehicle");
            return new UnableToMoveForward(this.currentPosition());
        }

        @Override
        public Coordinate currentPosition() {
            return coordinate;
        }

        @Override
        public String toString() {
            return String.format( "[Vehicle with current position %s and hash code %s ]",
                    this.currentPosition(), this.hashCode());
        }
    }
    
}
