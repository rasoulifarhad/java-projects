package com.farhad.example.functional_interface.default_methode;

public class SeaPlane extends Vehicle implements FastFly, Sail  {
    private int altitude;

    public  void cruise() {
        System.out.println("SeaPlane::cruise currently cruise like:");
        if(altitude > 0 ) {
            FastFly.super.cruise();
        } else {
            Sail.super.cruise();
        }
    }

    public static void main(String[] args) {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }
}
