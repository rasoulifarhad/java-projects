package com.farhad.example.enums;

import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass; //in kilograms
    private final double radius; // in meters

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    } 

    private Double getMass() {
        return this.mass;
    }

    private Double getRadius() {
        return this.radius;
    }

    // universal gravitational constant  (m3 kg-1 s-2) 6.6743E-11 
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * this.mass / (this.radius * this.radius);
    }

    double mass(double weight) {
        return weight / surfaceGravity();
    }

    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    public static void main(String[] args) {
        double  weightOnEarth = 95.0;
        // double  mass = weightOnEarth / EARTH.surfaceGravity();
        double  mass = EARTH.mass(weightOnEarth);
        Stream.of(Planet.values())
                .forEach(p ->  log.info("weight on {} is {}", p, p.surfaceWeight(mass)));
    }
}
