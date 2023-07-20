package com.farhad.example.designpatterns.dependencyinversionprinciple;

public class ElectricPowerSwitchDIDemo {
    
    public interface Switch {

        boolean isOn();
        void press();
    }

    public interface Switchable {

        void turnOn();
        void turnOf();
    }

    public static class ElectricPowerSwitch implements Switch {

        private Switchable client;
        private boolean on;

        public ElectricPowerSwitch(Switchable client) {
            this.client = client;
            on = false;
        }

        @Override
        public boolean isOn() {
            return on;
        }

        @Override
        public void press() {
            boolean checkOn = isOn();
            if (checkOn) {
                client.turnOf();
                on = false;
            } else {
                client.turnOn();
                on = true;
            }
        }
        
    }

    public static class LightBulb implements Switchable {

        @Override
        public void turnOf() {
            System.out.println("LightBulb: Bulb turned off...");            
        }

        @Override
        public void turnOn() {
            System.out.println("LightBulb: Bulb turned on...");            
        }
        
    }

    public static class Fan implements Switchable {

        @Override
        public void turnOf() {
            System.out.println("Fan: Bulb turned off...");            
        }

        @Override
        public void turnOn() {
            System.out.println("Fan: Bulb turned on...");            
        }
        
    }
}
