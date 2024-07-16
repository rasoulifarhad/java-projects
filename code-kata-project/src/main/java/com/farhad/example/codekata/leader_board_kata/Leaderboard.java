package com.farhad.example.codekata.leader_board_kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        Map<String, Integer> results = new HashMap<>();
        for (Race race : races) {
            for (Driver driver : race.getResults()) {
                String driverName = race.getDriverName(driver);
                int points = race.getPoints(driver);
                if(results.containsKey(driverName)) {
                    results.put(driverName, results.get(driverName) + points);
                } else {
                    results.put(driverName, 0 + points);
                }
            }
        }
        return results;
    }

    public List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        Collections.sort(resultsList, new Comparator<String>() {

            @Override
            public int compare(String driverName1, String driverName2) {
                return results.get(driverName1).compareTo(results.get(driverName2));
            }
            
        } );
        return resultsList;
    }

    
}
