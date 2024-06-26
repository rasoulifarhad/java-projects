package com.farhad.example.functional_interface.vehicle_demo.with_try;

import com.farhad.example.functional_interface.vehicle_demo.with_try.toolkit.Try;

public interface Vehicle {
 
    Try<Vehicle> wakeUp();

    Try<Vehicle> moveForward(Distance distance);

    Try<Vehicle> moveLeft(Distance distance);

    Try<Vehicle> moveRight(Distance distance);

    Try<Vehicle> stop();

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
        public Try<Vehicle> wakeUp() {
            System.out.println("vehicle is waking up.");
            return Try.of(() -> this);
        }

        @Override
        public Try<Vehicle> moveForward(Distance distance) {
            System.out.println("moving forward " + distance);
            return Try.of(() -> new Default(this.currentPosition().plus(new Coordinate(distance.getValue(), distance.getValue()))));
        }

        @Override
        public Try<Vehicle> moveLeft(Distance distance) {
            System.out.println("moving left " + distance);
            return Try.of(() -> new Default(this.currentPosition().plus(new Coordinate(distance.getValue(), 0))));
        }

        @Override
        public Try<Vehicle> moveRight(Distance distance) {
            System.out.println("moving right " + distance);
            return Try.of(() -> new Default(this.currentPosition().plus(new Coordinate(0, distance.getValue()))));
        }

        @Override
        public Try<Vehicle> stop() {
            System.out.println("stopping the vehicle");
            return Try.of(() -> this);
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
        public Try<Vehicle> wakeUp() {
            System.out.println("vehicle is waking up.");
            return Try.of(() -> new UnableToMoveForward(this.currentPosition()));
        }

        @Override
        public Try<Vehicle> moveForward(Distance distance) {
            System.out.println("moving forward " + distance);
            throw new RuntimeException("Unable to move the vehicle forward");
        }

        @Override
        public Try<Vehicle> moveLeft(Distance distance) {
            System.out.println("moving left " + distance);
            return Try.of(() -> new UnableToMoveForward(this.currentPosition().plus(new Coordinate(distance.getValue(), 0))));
        }

        @Override
        public Try<Vehicle> moveRight(Distance distance) {
            System.out.println("moving right " + distance);
            return Try.of(() -> new UnableToMoveForward(this.currentPosition().plus(new Coordinate(0, distance.getValue()))));
        }

        @Override
        public Try<Vehicle> stop() {
            System.out.println("stopping the vehicle");
            return Try.of(() -> new UnableToMoveForward(this.currentPosition()));
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
