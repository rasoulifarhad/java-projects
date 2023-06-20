package com.farhad.example.stream.collectors.model.city;

import java.util.stream.Stream;

public enum Area {

    Alabama,
    Alaska,
    Arizona,
    Arkansas,
    California,
    Colorado,
    Connecticut,
    Delaware,
    District_of_Columbia(AreaType.Federal_District),
    Florida,
    Georgia,
    Hawaii,
    Idaho,
    Illinois,
    Indiana,
    Iowa,
    Kansas,
    Kentucky,
    Louisiana,
    Maine,
    Maryland,
    Massachusetts,
    Michigan,
    Minnesota,
    Mississippi,
    Missouri,
    Montana,
    Nebraska,
    Nevada,
    New_Hampshire,
    New_Jersey,
    New_Mexico,
    New_York,
    North_Carolina,
    North_Dakota,
    Ohio,
    Oklahoma,
    Oregon,
    Pennsylvania,
    Rhode_Island,
    South_Carolina,
    South_Dakota,
    Tennessee,
    Texas,
    Utah,
    Vermont,
    Virginia,
    Washington,
    West_Virginia,
    Wisconsin,
    Wyoming;

    private final AreaType areaType;

    Area(AreaType areaType) {
        this.areaType = areaType;
    }

    Area() {
        this(AreaType.State);
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public Region getRegion() {
        return Stream.of(Region.values())
                    .filter(r -> r.getAreas().contains(this))
                    .findFirst()
                    .orElseThrow();
    }
}
