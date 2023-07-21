package com.farhad.example.designpatterns.liskovsubstitutionprinciple;

import lombok.Data;

public class LiskovSubstitutionDemo {
    
    @Data
    public static class TransportationDeviceBad {
        private String name ;
        private double speed;
        private Engine engine;

        void startEngine() {
            System.out.println("TransportationDevice: starting engine....");
        }
    }

    public static class CarBad extends TransportationDeviceBad {

        @Override
        void startEngine() {
            System.out.println("Car: starting engine....");
        }
        
    }

    // Everything isn’t going as planned now! Yes, a bicycle is a transportation device, however, it does not have an engine and hence, the 
    // method startEngine() cannot be implemented.
    public static class BicycleBad extends TransportationDeviceBad {

        @Override
        void startEngine() {
            System.out.println("Bicycle: starting engine....");
        }
        
    }

    public static class Engine {

    }

    @Data
    public static class TransportationDevivce  {
        private String name ;
        private double speed;
    }

    public static class  DevicesWithoutEngines extends TransportationDeviceBad {
        public void startMoving() {
            System.out.println("DevicesWithoutEngine: starting moving....");
        }
    }

    @Data
    public static class DevicesWithEngines extends TransportationDeviceBad {

        private Engine engine;

        public void startEngine() {
            System.out.println("DevicesWithEngines: starting engine....");
        }
    }

    public static class Car extends DevicesWithEngines {

    }

    public static class Bicycle extends DevicesWithoutEngines {
        
    } 
}
