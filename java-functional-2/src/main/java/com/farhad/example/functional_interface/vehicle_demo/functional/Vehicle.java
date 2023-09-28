package com.farhad.example.functional_interface.vehicle_demo.functional;

import lombok.RequiredArgsConstructor;

public interface Vehicle {
   
    Vehicle wakeUp();

    Vehicle moveForward(Distance distance);

    Vehicle moveLeft(Distance distance);

    Vehicle moveRight(Distance distance);

    Vehicle stop();

    Coordinate currentPosition();   
    
    @RequiredArgsConstructor
    class Default implements Vehicle {

        final Coordinate coordinate;

        public Default(){
            this(Coordinate.UNKNOWN);
        }

        @Override
        public Vehicle wakeUp() {
            System.out.println("vehicle is waking up");
            return this;
        }

        @Override
        public Vehicle moveForward(Distance distance) {
            System.out.println(String.format("moving vehicle forward %s %s", distance.getValue(), distance.getUnit()));
            return new Default(
                this.currentPosition()
                            .plus(
                                new Coordinate(
                                    distance.getValue(), 
                                    distance.getValue())));
        }

        @Override
        public Vehicle moveLeft(Distance distance) {
            System.out.println(String.format("moving vehicle left %s %s", distance.getValue(), distance.getUnit()));
            return new Default(
                this.currentPosition()
                            .plus(
                                new Coordinate(
                                    distance.getValue(), 
                                    0)));
        }

        @Override
        public Vehicle moveRight(Distance distance) {
            System.out.println(String.format("moving vehicle right %s %s", distance.getValue(), distance.getUnit()));
            return new Default(
                this.currentPosition()
                            .plus(
                                new Coordinate(
                                    0, 
                                    distance.getValue())));
        }

        @Override
        public Vehicle stop() {
             System.out.println("vehicle is going to sleep");
             return this;
        }

        @Override
        public Coordinate currentPosition() {
            return coordinate;
        }
    }  
    
}
