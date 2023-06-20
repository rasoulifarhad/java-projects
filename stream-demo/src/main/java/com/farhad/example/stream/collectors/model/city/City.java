package com.farhad.example.stream.collectors.model.city;

import lombok.Data;

@Data
public class City {
    private final String name ;
    private final Area area;
    private final Region region;
    private int population;

    public static City of(String name, Area area, int population) {
        return new City(name, area, population);
    }

    private City(String name, Area area, int population) {
        this.name = name;
        this.area = area;
        this.region = area.getRegion();
        this.population = population;
    }

    @Override
    public String toString() {
        return name;
    }

}
