package com.farhad.example.stream.collectors.model.city;

import static com.farhad.example.stream.collectors.model.city.Area.Alabama;
import static com.farhad.example.stream.collectors.model.city.Area.Alaska;
import static com.farhad.example.stream.collectors.model.city.Area.Arizona;
import static com.farhad.example.stream.collectors.model.city.Area.Arkansas;
import static com.farhad.example.stream.collectors.model.city.Area.California;
import static com.farhad.example.stream.collectors.model.city.Area.Colorado;
import static com.farhad.example.stream.collectors.model.city.Area.Connecticut;
import static com.farhad.example.stream.collectors.model.city.Area.Delaware;
import static com.farhad.example.stream.collectors.model.city.Area.District_of_Columbia;
import static com.farhad.example.stream.collectors.model.city.Area.Florida;
import static com.farhad.example.stream.collectors.model.city.Area.Georgia;
import static com.farhad.example.stream.collectors.model.city.Area.Hawaii;
import static com.farhad.example.stream.collectors.model.city.Area.Idaho;
import static com.farhad.example.stream.collectors.model.city.Area.Illinois;
import static com.farhad.example.stream.collectors.model.city.Area.Indiana;
import static com.farhad.example.stream.collectors.model.city.Area.Iowa;
import static com.farhad.example.stream.collectors.model.city.Area.Kansas;
import static com.farhad.example.stream.collectors.model.city.Area.Kentucky;
import static com.farhad.example.stream.collectors.model.city.Area.Louisiana;
import static com.farhad.example.stream.collectors.model.city.Area.Maine;
import static com.farhad.example.stream.collectors.model.city.Area.Maryland;
import static com.farhad.example.stream.collectors.model.city.Area.Massachusetts;
import static com.farhad.example.stream.collectors.model.city.Area.Michigan;
import static com.farhad.example.stream.collectors.model.city.Area.Minnesota;
import static com.farhad.example.stream.collectors.model.city.Area.Mississippi;
import static com.farhad.example.stream.collectors.model.city.Area.Missouri;
import static com.farhad.example.stream.collectors.model.city.Area.Montana;
import static com.farhad.example.stream.collectors.model.city.Area.Nebraska;
import static com.farhad.example.stream.collectors.model.city.Area.Nevada;
import static com.farhad.example.stream.collectors.model.city.Area.New_Hampshire;
import static com.farhad.example.stream.collectors.model.city.Area.New_Jersey;
import static com.farhad.example.stream.collectors.model.city.Area.New_Mexico;
import static com.farhad.example.stream.collectors.model.city.Area.New_York;
import static com.farhad.example.stream.collectors.model.city.Area.North_Carolina;
import static com.farhad.example.stream.collectors.model.city.Area.North_Dakota;
import static com.farhad.example.stream.collectors.model.city.Area.Ohio;
import static com.farhad.example.stream.collectors.model.city.Area.Oklahoma;
import static com.farhad.example.stream.collectors.model.city.Area.Oregon;
import static com.farhad.example.stream.collectors.model.city.Area.Pennsylvania;
import static com.farhad.example.stream.collectors.model.city.Area.Rhode_Island;
import static com.farhad.example.stream.collectors.model.city.Area.South_Carolina;
import static com.farhad.example.stream.collectors.model.city.Area.South_Dakota;
import static com.farhad.example.stream.collectors.model.city.Area.Tennessee;
import static com.farhad.example.stream.collectors.model.city.Area.Texas;
import static com.farhad.example.stream.collectors.model.city.Area.Utah;
import static com.farhad.example.stream.collectors.model.city.Area.Vermont;
import static com.farhad.example.stream.collectors.model.city.Area.Virginia;
import static com.farhad.example.stream.collectors.model.city.Area.Washington;
import static com.farhad.example.stream.collectors.model.city.Area.West_Virginia;
import static com.farhad.example.stream.collectors.model.city.Area.Wisconsin;
import static com.farhad.example.stream.collectors.model.city.Area.Wyoming;

import java.util.Set;

public enum Region {

    New_England(Connecticut, Maine, Massachusetts, New_Hampshire, Rhode_Island, Vermont),
    Mideast(Delaware, District_of_Columbia, Maryland, New_Jersey, New_York, Pennsylvania),
    Great_Lakes(Illinois, Indiana, Michigan, Ohio, Wisconsin),
    Plains(Iowa, Kansas, Minnesota, Missouri, Nebraska, North_Dakota, South_Dakota),
    Southeast(Alabama, Arkansas, Florida, Georgia, Kentucky, Louisiana, Mississippi, North_Carolina, South_Carolina, Tennessee, Virginia, West_Virginia),
    Southwest(Arizona, New_Mexico, Oklahoma, Texas),
    Rocky_Mountain(Colorado, Idaho, Montana, Utah, Wyoming),
    Far_West(Alaska, California, Hawaii, Nevada, Oregon, Washington);

    private final Set<Area> areas;

    Region(Area... areas) {
        this.areas = Set.of(areas);
    }
    public Set<Area> getAreas() {
        return this.areas;
    }
}
