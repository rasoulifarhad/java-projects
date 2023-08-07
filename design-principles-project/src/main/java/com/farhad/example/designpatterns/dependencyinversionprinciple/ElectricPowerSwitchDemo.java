package com.farhad.example.designpatterns.dependencyinversionprinciple;

public class ElectricPowerSwitchDemo {
    

    public static class LightBulb {

        public void turnOn() {
            System.out.println("LightBulb: Bulb turned on...");
        }

        public void turnOff() {
            System.out.println("LightBulb: Bulb turned off...");
        }
    }


    public static class ElectricPowerSwitch {

        private boolean on;
        private final LightBulb lightBulb;
        
        public ElectricPowerSwitch(LightBulb lightBulb) {
            this.lightBulb = lightBulb;
            on = false;
        }

        public boolean isOn() {
            return  this.on;
        }

        public void press() {
            boolean checkOn = isOn();
            if (checkOn) {
                lightBulb.turnOff();
                on = false;
            } else {
                lightBulb.turnOn();
                on = true;
            }
        }

    }
}
