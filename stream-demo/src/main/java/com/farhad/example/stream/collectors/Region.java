package com.farhad.example.stream.collectors;

import static com.farhad.example.stream.collectors.Area.Alabama;
import static com.farhad.example.stream.collectors.Area.Alaska;
import static com.farhad.example.stream.collectors.Area.Arizona;
import static com.farhad.example.stream.collectors.Area.Arkansas;
import static com.farhad.example.stream.collectors.Area.California;
import static com.farhad.example.stream.collectors.Area.Colorado;
import static com.farhad.example.stream.collectors.Area.Connecticut;
import static com.farhad.example.stream.collectors.Area.Delaware;
import static com.farhad.example.stream.collectors.Area.District_of_Columbia;
import static com.farhad.example.stream.collectors.Area.Florida;
import static com.farhad.example.stream.collectors.Area.Georgia;
import static com.farhad.example.stream.collectors.Area.Hawaii;
import static com.farhad.example.stream.collectors.Area.Idaho;
import static com.farhad.example.stream.collectors.Area.Illinois;
import static com.farhad.example.stream.collectors.Area.Indiana;
import static com.farhad.example.stream.collectors.Area.Iowa;
import static com.farhad.example.stream.collectors.Area.Kansas;
import static com.farhad.example.stream.collectors.Area.Kentucky;
import static com.farhad.example.stream.collectors.Area.Louisiana;
import static com.farhad.example.stream.collectors.Area.Maine;
import static com.farhad.example.stream.collectors.Area.Maryland;
import static com.farhad.example.stream.collectors.Area.Massachusetts;
import static com.farhad.example.stream.collectors.Area.Michigan;
import static com.farhad.example.stream.collectors.Area.Minnesota;
import static com.farhad.example.stream.collectors.Area.Mississippi;
import static com.farhad.example.stream.collectors.Area.Missouri;
import static com.farhad.example.stream.collectors.Area.Montana;
import static com.farhad.example.stream.collectors.Area.Nebraska;
import static com.farhad.example.stream.collectors.Area.Nevada;
import static com.farhad.example.stream.collectors.Area.New_Hampshire;
import static com.farhad.example.stream.collectors.Area.New_Jersey;
import static com.farhad.example.stream.collectors.Area.New_Mexico;
import static com.farhad.example.stream.collectors.Area.New_York;
import static com.farhad.example.stream.collectors.Area.North_Carolina;
import static com.farhad.example.stream.collectors.Area.North_Dakota;
import static com.farhad.example.stream.collectors.Area.Ohio;
import static com.farhad.example.stream.collectors.Area.Oklahoma;
import static com.farhad.example.stream.collectors.Area.Oregon;
import static com.farhad.example.stream.collectors.Area.Pennsylvania;
import static com.farhad.example.stream.collectors.Area.Rhode_Island;
import static com.farhad.example.stream.collectors.Area.South_Carolina;
import static com.farhad.example.stream.collectors.Area.South_Dakota;
import static com.farhad.example.stream.collectors.Area.Tennessee;
import static com.farhad.example.stream.collectors.Area.Texas;
import static com.farhad.example.stream.collectors.Area.Utah;
import static com.farhad.example.stream.collectors.Area.Vermont;
import static com.farhad.example.stream.collectors.Area.Virginia;
import static com.farhad.example.stream.collectors.Area.Washington;
import static com.farhad.example.stream.collectors.Area.West_Virginia;
import static com.farhad.example.stream.collectors.Area.Wisconsin;
import static com.farhad.example.stream.collectors.Area.Wyoming;

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
