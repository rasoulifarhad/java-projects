package com.farhad.example.codekata.leader_board_kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private static final Integer [] POINTS = new Integer[] {25, 18, 15};

    private final String name;
    private final List<Driver> results;
    private final Map<Driver, String> driverNames;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers) ;
        this.driverNames = new HashMap<>();
        for (Driver driver : results) {
            String driverName = driver.getName();
            if(driver instanceof SelfDrivingCar) {
                driverName = "Self Driving Car - " + driver.getCountry() + " (" + ((SelfDrivingCar) driver).getAlgorithmVersion() + ")";
            }
            this.driverNames.put(driver, driverName);
        }
    }

    public List<Driver> getResults() {
        return this.results;
    }

    public int getPoints(Driver driver) {
        return Race.POINTS[position(driver)];
    }

    private int position(Driver driver) {
        return this.results.indexOf(driver);
    }

    public String getDriverName(Driver driver) {
        return driverNames.get(driver);
    }

    @Override
    public String toString() {
        return name;
    }

    

}
